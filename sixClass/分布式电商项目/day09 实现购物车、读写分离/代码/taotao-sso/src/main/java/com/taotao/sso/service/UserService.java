package com.taotao.sso.service;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.service.RedisService;
import com.taotao.sso.mapper.UserMapper;
import com.taotao.sso.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisService redisService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	/**
	 * 校验数据
	 * @param param  要校验的数据
	 * @param type   数据类型
	 * @return
	 */
	public Boolean check(String param, int type) {
		User record = new User();
		switch (type) {
		case 1:
			record.setUsername(param);
			break;
		case 2:
			record.setPhone(param);
			break;
		case 3:
			record.setEmail(param);
			break;
		default:
			return null;
		}
		return userMapper.selectOne(record) == null;
	}
	
	/**
	 * 注册保存用户信息
	 * @param user
	 * @return
	 */
	public Boolean doRegister(User user) {
		user.setCreated(new Date());
		user.setId(null);
		//密码md5加密后存储
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		user.setUpdated(user.getCreated());
		return userMapper.insert(user) == 1;
	}
	/**
	 * 用户登录并且返回token信息（唯一）
	 * @param username
	 * @param password
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String doLogin(String username, String password) throws JsonProcessingException {
		User record = new User();
		record.setUsername(username);
		User user = userMapper.selectOne(record);
		if(user == null){
			return null;
		}
		//判断密码是否一致
		if(!user.getPassword().endsWith(DigestUtils.md5Hex(password))){
			return null;
		}
		//生成token字符串
		String token = "TAOTAO_"+DigestUtils.md5Hex(username+System.currentTimeMillis());
		redisService.set(token, objectMapper.writeValueAsString(user), 60*30);
		return token;
	}
	/**
	 * 根据token查询用户信息
	 * @param token
	 * @return
	 */
	public User queryUserByToken(String token) {
		if(token == null){
			return null;
		}
		String str =  redisService.get(token);
		if(str == null){
			//表示用户身份信息已经失效
			return null;
		}
		//把用户身份信息再延迟30分钟，（相对时间）
		redisService.expire(token,60*30);
		
		try {
			User user = objectMapper.readValue(str, User.class);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
