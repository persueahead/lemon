package com.taotao.web.service;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.service.ApiService;
import com.taotao.sso.query.bean.User;
import com.taotao.sso.query.service.UserQueryService;

@Service
public class UserService {
	@Autowired
	private ApiService apiService;
	private ObjectMapper objectMapper = new ObjectMapper();
	@Value("${SSO_TAOTAO_URL}")
	private String SSO_TAOTAO_URL;
	@Autowired
	private UserQueryService userQueryService;
	
	public User queryUserByToken(String token){
		
		
	/*	try {
			String strJson = apiService.doGet(SSO_TAOTAO_URL+"/service/user/"+token);
			if(StringUtils.isNoneBlank(strJson)){
				User user = objectMapper.readValue(strJson, User.class);
				if(user != null){
					return user;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		User user = userQueryService.queryUserByToken(token);
		return user;
	}
}
