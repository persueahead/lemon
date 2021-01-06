package com.example.ln.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@Value(value="${user.userId}")
	private String userId;
	
	@Value(value="${user.userName}")
	private String userName;
	
	@Value(value="${user.userAge}")
	private String userAge;

	@RequestMapping("/index")
	public String index() {
		return "spring boot ..... userid="+userId+"  userName="+userName+" userAge="+userAge;
	}
	
}