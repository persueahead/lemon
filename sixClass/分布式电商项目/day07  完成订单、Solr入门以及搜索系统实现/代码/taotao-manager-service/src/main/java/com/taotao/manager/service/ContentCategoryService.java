package com.taotao.manager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taotao.manager.pojo.ContentCategory;
@Service
public class ContentCategoryService  extends BaseService<ContentCategory>{

	public void saveContentCategory(ContentCategory record) {
		save(record);
		//更改父节点上的isParent属性为true
		ContentCategory contentCategory = new ContentCategory();
		contentCategory.setId(record.getParentId());
		contentCategory.setIsParent(true);
		updateSelective(contentCategory);//根据主键id更新不为空的字段
		
	}

	public void deleteAll(Long parentId, Long id) {
		//根据id删除当前节点以及其底下的子节点和孙子几点
		List<Object> ids = new ArrayList<Object>();
		ids.add(id);
		findAllIds(ids,id);
		deleteByIds(ids, ContentCategory.class, "id");
		//判断父节点上是否还有子节点，如果没有，则将父节点的isparent设置为false
		ContentCategory record = new ContentCategory();
		record.setParentId(parentId);
		List<ContentCategory> list = queryListByWhere(record);
		if(null == list || list.size() == 0){
			ContentCategory contentCategory = new ContentCategory();
			contentCategory.setId(parentId);
			contentCategory.setIsParent(false);
			updateSelective(contentCategory);
		}
		
	}

	private void findAllIds(List<Object> ids, Long id) {
		ContentCategory category = new ContentCategory();
		category.setParentId(id);
		List<ContentCategory> list = queryListByWhere(category);
		if(null != list && list.size() > 0){
			for(ContentCategory c : list){
				ids.add(c.getId());
				if(c.getIsParent()){
					findAllIds(ids,c.getId());
				}
			}
		}
		
	}

}
