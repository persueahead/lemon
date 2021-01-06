package com.example.ln.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@RequestMapping("/index")
	public String index() {
		System.out.println("...hello springboot....");
		return "hello world...";
	}
	
}
