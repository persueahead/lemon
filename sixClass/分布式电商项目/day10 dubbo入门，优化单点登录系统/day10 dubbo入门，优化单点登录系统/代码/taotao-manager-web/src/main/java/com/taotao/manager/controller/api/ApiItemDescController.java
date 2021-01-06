package com.taotao.manager.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.manager.pojo.Item;
import com.taotao.manager.pojo.ItemDesc;
import com.taotao.manager.service.ItemDescService;
import com.taotao.manager.service.ItemService;

@Controller
@RequestMapping("api/item/desc")
public class ApiItemDescController {
	@Autowired
	private ItemDescService itemDescService;
	@RequestMapping(value="{itemId}")
	public ResponseEntity<ItemDesc> queryItemById(@PathVariable("itemId")Long itemId){
		try {
			ItemDesc itemDesc = itemDescService.queryById(itemId);
			if(null == itemDesc){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(itemDesc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

}
