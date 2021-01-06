package com.taotao.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.bean.EasyUIResult;
import com.taotao.manager.mapper.ItemMapper;
import com.taotao.manager.pojo.Item;
import com.taotao.manager.pojo.ItemDesc;
import com.taotao.manager.pojo.ItemParamItem;
@Service
public class ItemService extends BaseService<Item>{
	@Autowired
	private ItemDescService itemDescService;
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemParamItemService itemParamItemService;
	/**
	 * 保存商品的数据
	 * @param item
	 * @param desc
	 * @param itemParams 
	 * @param itemParams 
	 * @return
	 */
	public boolean saveItem(Item item, String desc, String itemParams) {
		item.setStatus(1);
		item.setId(null);
		int count1 = save(item);
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(item.getId());
		int count2 = itemDescService.save(itemDesc);
		ItemParamItem itemParamItem = new ItemParamItem();
		itemParamItem.setItemId(item.getId());
		itemParamItem.setParamData(itemParams);
		int count3 = itemParamItemService.save(itemParamItem);
		return count1 == 1 && count2 == 1 && count3 == 1;
	}
	/**
	 * 根据分页的页码和分页大小查询分页数据
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public EasyUIResult queryItemList(int pageNo, int pageSize) {
		//开启分页功能
		PageHelper.startPage(pageNo, pageSize);
		//通过mapper查询数据库中的数据
		Example example = new Example(Item.class);
		example.setOrderByClause("updated DESC");
		List<Item> items = itemMapper.selectByExample(example);
		PageInfo<Item> info = new PageInfo<Item>(items);
		return new EasyUIResult(info.getTotal(), info.getList());
	}
	/**
	 * 编辑更新商品数据
	 * @param item
	 * @param desc
	 * @param itemParams 
	 * @return
	 */
	public boolean updateItem(Item item, String desc, String itemParams) {
		//保持商品的状态不变
		item.setStatus(null);
		int count1 = updateSelective(item);
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		int count2 = itemDescService.updateSelective(itemDesc);
		int count3 = itemParamItemService.updateItemParamItemSelective(item.getId(),itemParams);
		
		return count1 == 1 && count2 == 1 && count3 == 1;
	}

}
