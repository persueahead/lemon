package com.example.ln.dao;

import java.util.List;
import java.util.Map;

import com.example.ln.po.UserInfo;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserInfoDAO {

	/**
	 * 添加用户信息
	 * @param user 用户信息
	 * @return 返回影响的行数
	 */
	public int addUser(UserInfo user);
	
	/**
	 * 修改用户信息
	 * @param user 用户信息
	 * @return 返回影响的行数
	 */
	public int updateUser(UserInfo user);
	
	/**
	 * 删除用户信息
	 * @param user 用户信息
	 * @return 返回影响的行数
	 */
	public int deleteUser(UserInfo user);
	
	/**
	 * 根据条件查询用户信息
	 * @param user
	 * @return
	 */
	public UserInfo getUser(UserInfo user);
	
	
	/**
	 * 根据条件查询用户信息
	 * @param user
	 * @return
	 */
	public List<Map<String, Object>> getList(UserInfo user);
	
}
