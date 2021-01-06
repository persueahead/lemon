package com.taotao.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.manager.pojo.ItemParam;
import com.taotao.manager.service.ItemParamService;

@Controller
@RequestMapping("item/param")
public class ItemParamController {
	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping(value="{itemCatId}",method=RequestMethod.GET)
	public ResponseEntity<ItemParam> queryByItemCatId(@PathVariable("itemCatId")Long itemCatId){
		try {
			ItemParam record = new ItemParam();
			record.setItemCatId(itemCatId);
			ItemParam param = itemParamService.queryOne(record);
			if(null == param){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	@RequestMapping(value="{itemCatId}",method=RequestMethod.POST)
	public  ResponseEntity<Void> saveItemParam(@PathVariable("itemCatId")Long itemCatId,@RequestParam("paramData")String paramData){
		try {
			ItemParam param = new ItemParam();
			param.setId(null);
			param.setItemCatId(itemCatId);
			param.setParamData(paramData);
			int count = itemParamService.save(param);
			if(count == 0){
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
