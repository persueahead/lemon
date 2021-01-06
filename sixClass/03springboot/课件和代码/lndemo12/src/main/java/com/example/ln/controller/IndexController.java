package com.example.ln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index/")
public class IndexController {

	@RequestMapping("hello")
	public String hello(Model model) throws Exception {
		System.out.println("-----------hello--------");
		
		model.addAttribute("info", "hello spring boot");
		if(true) {
			throw new RuntimeException("老牛自定义的运行时异常");
		}
		
		return "hello";
	}
	
}
