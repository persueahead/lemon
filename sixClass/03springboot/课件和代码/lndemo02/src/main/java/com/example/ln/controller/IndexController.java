package com.example.ln.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ln.po.UserInfo;

@RestController
@RequestMapping("/index/")
public class IndexController {

	
	@RequestMapping("test")
	public String test() {
		System.out.println("-------test-----");
		return "hello";
	}

	@RequestMapping("find/{id}/{name}")
	public UserInfo find(@PathVariable Integer id,@PathVariable String name) {
		
		UserInfo user = new UserInfo();
		user.setUserId(id);
		user.setUserName(name);
		
		System.out.println(user);
		
		return user;
	}
	
	
	
}
