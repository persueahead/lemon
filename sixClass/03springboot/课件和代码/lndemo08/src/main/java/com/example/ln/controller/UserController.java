package com.example.ln.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ln.po.UserInfo;

@Controller
public class UserController {

	@RequestMapping("/list")
	public String list(Model model) {
		
		List<UserInfo> list = new ArrayList<>();
		
		for(int i = 0;i<20;i++) {
			UserInfo user = new UserInfo();
			user.setUserId(100+i);
			user.setUserName("张小"+i);
			user.setUserSex("男");
			user.setUserAge(10+i);
			list.add(user);
		}
		
		model.addAttribute("list", list);
		
		
		return "user/user_list";
	}
	
}
