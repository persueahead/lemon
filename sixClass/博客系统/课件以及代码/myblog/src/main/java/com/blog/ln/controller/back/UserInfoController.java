package com.blog.ln.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.ln.bean.UserInfo;
import com.blog.ln.service.UserInfoService;
import com.blog.ln.utils.PageBean;

/**
 * 用户管理的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/back/user/")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userservcie;

	/**
	 * 根据分页查询用户信息
	 * @param user
	 * @param model
	 * @param page 
	 * @return
	 */
	@RequestMapping("list")
	public String list(UserInfo user,Model model,Integer page) {
		
		PageBean<UserInfo> pageBean = userservcie.getList(user, page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("userinfo", user);
		
		
		return "back/userinfo/userinfo_list";
	}
	
	@RequestMapping("add")
	public String add() {
		return "back/userinfo/userinfo_add";
	}
	
}
