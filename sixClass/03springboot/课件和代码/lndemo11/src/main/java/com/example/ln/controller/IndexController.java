package com.example.ln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index/")
public class IndexController {

	@RequestMapping("hello")
	public String hello(Model model) {
		System.out.println("-----------hello--------");
		//int c = 2/0;
		model.addAttribute("info", "hello spring boot");
		return "hello";
	}
	
}
