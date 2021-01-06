package com.taotao.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.manager.pojo.Item;
import com.taotao.manager.pojo.ItemDesc;
@Service
public class ItemService extends BaseService<Item>{
	@Autowired
	private ItemDescService itemDescService;
	/**
	 * 保存商品的数据
	 * @param item
	 * @param desc
	 * @return
	 */
	public boolean saveItem(Item item, String desc) {
		item.setStatus(1);
		item.setId(null);
		int count1 = save(item);
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(item.getId());
		int count2 = itemDescService.save(itemDesc);
		return count1 == 1 && count2 == 1;
	}

}
