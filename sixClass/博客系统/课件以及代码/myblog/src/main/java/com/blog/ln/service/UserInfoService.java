package com.blog.ln.service;

import com.blog.ln.bean.UserInfo;
import com.blog.ln.utils.PageBean;

/**
 * 用户管理的业务逻辑接口
 * @author Administrator
 *
 */
public interface UserInfoService {
	
	/**
	 * 根据分页条件查询用户信息
	 * @param user 查询条件
	 * @param page 页数
	 * @return
	 */
	public PageBean<UserInfo> getList(UserInfo user,Integer page);
	
}
