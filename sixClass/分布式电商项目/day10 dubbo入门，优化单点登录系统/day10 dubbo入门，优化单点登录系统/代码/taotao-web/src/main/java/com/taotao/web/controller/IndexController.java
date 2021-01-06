package com.taotao.web.controller;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.web.service.IndexService;

@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;
	
	@RequestMapping(value="index",method = RequestMethod.GET)
	public ModelAndView  index(){
		ModelAndView modelAndView = new ModelAndView("index");
		//通过java代码跨域访问后台系统，请求数据
		String indexAd1 = indexService.queryIndexAd1();
		modelAndView.addObject("indexAd1", indexAd1);
		String indexAd2 = indexService.queryIndexAd2();
		modelAndView.addObject("indexAd2", indexAd2);
		return modelAndView;
	}
}
