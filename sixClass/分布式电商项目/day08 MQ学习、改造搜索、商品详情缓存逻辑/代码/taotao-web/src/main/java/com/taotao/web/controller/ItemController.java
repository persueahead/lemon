package com.taotao.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.manager.pojo.Item;
import com.taotao.manager.pojo.ItemDesc;
import com.taotao.manager.pojo.ItemParamItem;
import com.taotao.web.bean.ItemVo;
import com.taotao.web.service.ItemService;

@Controller
@RequestMapping("item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping(value="{itemId}",method=RequestMethod.GET)
	public ModelAndView queryItemById(@PathVariable("itemId")Long itemId){
		ModelAndView modelAndView = new ModelAndView("item");
		ItemVo item = itemService.queryItemById(itemId);
		modelAndView.addObject("item", item);
		//查询商品的描述信息
		ItemDesc itemDesc = itemService.queryItemDescById(itemId);
		modelAndView.addObject("itemDesc", itemDesc);
		//查询商品的规格数据
		String itemParam = itemService.queryItemParamItemByItemId(itemId);
		modelAndView.addObject("itemParam", itemParam);
		return modelAndView;
	}
}
