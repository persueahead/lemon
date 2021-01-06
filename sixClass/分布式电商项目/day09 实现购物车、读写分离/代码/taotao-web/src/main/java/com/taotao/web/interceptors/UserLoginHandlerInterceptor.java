package com.taotao.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.common.service.ApiService;
import com.taotao.common.utils.CookieUtils;
import com.taotao.web.bean.User;
import com.taotao.web.service.UserService;
import com.taotao.web.threadlocal.UserThreadlocal;

public class UserLoginHandlerInterceptor implements HandlerInterceptor{
	
	public static String TAOTAO_COOKIE = "taotao_cookie";
	
	@Autowired
	private ApiService ApiService;
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	     String token =  CookieUtils.getCookieValue(request, TAOTAO_COOKIE);
	     if(!StringUtils.isNotBlank(token)){
	    	 //跳转到登陆页面
	    	 response.sendRedirect("http://sso.taotao.com/user/login.html");
	    	 return false;
	     }
	     //通过service实现跨域请求user信息
	     User user = userService.queryUserByToken(token);
	     if(user == null){
	    	//跳转到登陆页面
	    	 response.sendRedirect("http://sso.taotao.com/user/login.html"); 
	    	 return false;
	     }
	     UserThreadlocal.set(user);
		return true;
		//.\mysqld.exe install MySQL-3381 --defaults-file="E:\0729\3381\data\my.ini"
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		UserThreadlocal.set(null);
		
	}

}
