package com.taotao.web.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.service.ApiService;
import com.taotao.web.bean.Cart;
import com.taotao.web.threadlocal.UserThreadlocal;

@Service
public class CartService {
	
	private ObjectMapper ObjectMapper = new ObjectMapper();
	@Autowired
	private ApiService apiService;
	public List<Cart> queryCarts(){
		try {
			Long userId = UserThreadlocal.get().getId();
			String jsonStr = apiService.doGet("http://cart.taotao.com/service/api/cart/query/list/"+userId);
			if(StringUtils.isNotEmpty(jsonStr)){
				return ObjectMapper.readValue(jsonStr, ObjectMapper.getTypeFactory().constructCollectionType(List.class, Cart.class));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
