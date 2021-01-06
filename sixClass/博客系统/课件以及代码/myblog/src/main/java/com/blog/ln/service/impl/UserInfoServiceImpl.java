package com.blog.ln.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.ln.bean.UserInfo;
import com.blog.ln.dao.UserInfoMapper;
import com.blog.ln.service.UserInfoService;
import com.blog.ln.utils.Const;
import com.blog.ln.utils.PageBean;
import com.blog.ln.utils.PageUtil;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper usermapper;
	
	@Override
	public PageBean<UserInfo> getList(UserInfo user, Integer page) {
		
		//总记录数
		int allRow = usermapper.getUserCount(user).intValue();
		//总页数
		int totalPage = PageUtil.countTotalPage(allRow, Const.PAGE_SIZE);
		//当前第几页
		int currentPage = PageUtil.countCurrentPage(page);
		//起始记录数
		int start = PageUtil.countStart(Const.PAGE_SIZE, currentPage);
		
		if(page>=0) {
			user.setStart(start);
			user.setLength(Const.PAGE_SIZE);
		}else {
			user.setStart(-1);
			user.setLength(-1);
		}
		
		List<UserInfo> users = usermapper.getUserList(user);
		
		PageBean<UserInfo> pageBean = new PageBean<>();
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(users);
		
		
		return pageBean;
	}

}
