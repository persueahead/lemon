package com.example.ln.service;

import com.example.ln.po.UserInfo;

public interface UserService {

	/**
	 * 添加或修改数据
	 * @param user
	 */
	public void addOrUpdate(UserInfo user) ;
	
	/**
	 * 根据编号查询用户信息
	 * @param userId
	 * @return
	 */
	public UserInfo getUser(UserInfo user);
}
