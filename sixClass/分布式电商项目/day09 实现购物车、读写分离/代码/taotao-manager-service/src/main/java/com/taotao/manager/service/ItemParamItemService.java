package com.taotao.manager.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.taotao.manager.mapper.ItemParamItemMapper;
import com.taotao.manager.pojo.ItemParamItem;
@Service
public class ItemParamItemService extends BaseService<ItemParamItem>{
	@Autowired
	private ItemParamItemMapper itemParamItemMapper;
	/**
	 * 根据商品的id跟新商品规格数据
	 * @param id
	 * @param itemParams
	 * @return
	 */
	public int updateItemParamItemSelective(Long id, String itemParams) {
		ItemParamItem item = new ItemParamItem();
		item.setUpdated(new Date());
		item.setParamData(itemParams);
		Example example = new Example(ItemParamItem.class);
		example.createCriteria().andEqualTo("itemId", id);
		return itemParamItemMapper.updateByExampleSelective(item, example);
	}

}
