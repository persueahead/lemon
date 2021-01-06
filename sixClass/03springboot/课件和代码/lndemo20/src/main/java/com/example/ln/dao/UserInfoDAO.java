package com.example.ln.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.ln.bean.UserInfo;

@Mapper
public interface UserInfoDAO {

	/**
	 * 查询用户信息
	 * @param id
	 * @return
	 */
	public UserInfo findById(Integer id);
	
}
