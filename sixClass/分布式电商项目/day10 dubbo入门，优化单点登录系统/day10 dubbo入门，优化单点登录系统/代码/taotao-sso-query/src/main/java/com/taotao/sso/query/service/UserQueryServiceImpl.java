package com.taotao.sso.query.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.service.RedisService;
import com.taotao.sso.query.bean.User;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private RedisService redisService;

    private static final Integer REDIS_TIME = 60 * 30;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
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
		redisService.expire(token,REDIS_TIME);
		
		try {
			User user = MAPPER.readValue(str, User.class);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    

}
