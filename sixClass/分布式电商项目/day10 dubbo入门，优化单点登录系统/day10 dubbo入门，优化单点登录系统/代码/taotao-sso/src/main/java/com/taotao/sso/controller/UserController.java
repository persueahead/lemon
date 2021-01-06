package com.taotao.sso.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.CookieUtils;
import com.taotao.sso.pojo.User;
import com.taotao.sso.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static String TAOTAO_COOKIE = "taotao_cookie";
	@Autowired
	private UserService userService;
	/**
	 * 跳转登录页面
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	/**
	 * 跳转注册页面
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String regist(){
		return "register";
	}
	/**
	 * 注册时数据监测接口
	 * @param param
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/check/{param}/{type}",method=RequestMethod.GET)
	public ResponseEntity<Boolean> check(@PathVariable("param")String param,
			@PathVariable("type")int type){
		try {
			Boolean flag = userService.check(param,type);
			if(flag == null){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
			return ResponseEntity.ok(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
	}
	/**
	 * 注册接口
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value="/doRegister",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doRegister(@Valid User user,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<String, Object>();
		if(bindingResult.hasErrors()){
			List<String> strs = new ArrayList<String>();
			List<ObjectError> list = bindingResult.getAllErrors();
			if(list != null){
				for(ObjectError error:list){
					String message = error.getDefaultMessage();
					strs.add(message);
				}
				map.put("status", 400);
				map.put("data", "数据校验失败，错误信息是"+StringUtils.join(strs, "|"));
				return map;
			}
			
		}
		
		try {
			Boolean flag = userService.doRegister(user);
			if(flag){
				map.put("status", 200);
			}else{
				map.put("status", 500);
				map.put("data", "辛苦你了");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 500);
			map.put("data", "辛苦你了");
		}
		return map;
	}
	/**
	 * 根据token查询用户身份信息
	 * @return
	 */
	@RequestMapping(value="{token}",method=RequestMethod.GET)
	public ResponseEntity<User> queryUserByToken(@PathVariable("token")String token){
		/*try {
			User user = userService.queryUserByToken(token);
			if(user== null){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		User user = new User();
		user.setUsername("当前接口不可用，请访问dubbo中提供的查询用户的服务即可");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
	}
	
	/**
	 * 登陆
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	public Map<String,Object> doLogin(User user,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			//redis   （token,用户信息）
			String token = userService.doLogin(user.getUsername(),user.getPassword());
			if(token == null){
				map.put("status", 400);
				map.put("data", "登录失败，请重试");
				return map;
			}
			//需要将token保存到cookie中，以便在访问其他的资源时会将cookie中的token携带过来。
			CookieUtils.setCookie(request,response, TAOTAO_COOKIE, token);
			map.put("status", 200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("status", 400);
			map.put("data", "登录失败，请重试");
		}
		return map;
		
		
	}
}
