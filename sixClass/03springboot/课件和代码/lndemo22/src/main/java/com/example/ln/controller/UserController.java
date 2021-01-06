package com.example.ln.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ln.po.UserInfo;
import com.example.ln.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice; 
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(UserInfo user) {
		
		userservice.addOrUpdate(user);
		
		return "index";
	}
	
	@RequestMapping("/show")
	public String show(UserInfo user,Model model) {
		
		UserInfo userinfo = userservice.getUser(user);
		model.addAttribute("user", userinfo);
		
		return "index";
		
	}
}
