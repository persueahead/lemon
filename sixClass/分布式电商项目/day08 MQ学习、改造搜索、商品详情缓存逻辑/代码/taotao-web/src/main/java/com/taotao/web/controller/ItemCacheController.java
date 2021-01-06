package com.taotao.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taotao.common.service.RedisService;
import com.taotao.web.service.ItemService;

@Controller
@RequestMapping("item/cache")
public class ItemCacheController {
	
	@Autowired
	private RedisService redisService;
	@RequestMapping(value="{itemId}",method=RequestMethod.POST)
	public ResponseEntity<Void> deleByItemId(@PathVariable("itemId")Long itemId){
		try {
			redisService.del(ItemService.KEY+"_"+itemId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
