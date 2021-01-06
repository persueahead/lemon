package com.example.ln.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ln.dao.UserDAO;
import com.example.ln.po.UserInfo;
import com.example.ln.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userdao ;
	
	@Override
	public void addOrUpdate(UserInfo user) {
		System.out.println("更新数据id="+user.getUserId()+"的数据");
		userdao.save(user);
	}

	@Override
	public UserInfo getUser(UserInfo user) {
		System.out.println("查询id="+user.getUserId()+"的数据");
		return userdao.findByUserId(user.getUserId());
	}

}
