package com.taotao.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taotao.manager.pojo.ItemParamItem;
import com.taotao.manager.service.ItemParamItemService;

@Controller
@RequestMapping("item/param/item")
public class ItemParamItemController {
	@Autowired
	private ItemParamItemService itemParamItemService;
	@RequestMapping(value = "{itemId}",method=RequestMethod.GET)
	public ResponseEntity<ItemParamItem> queryByItemId(@PathVariable("itemId")Long itemId){
		try {
			ItemParamItem record = new ItemParamItem();
			record.setItemId(itemId);
			ItemParamItem item = itemParamItemService.queryOne(record);
			if(null == item){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
}
