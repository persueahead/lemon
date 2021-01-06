package com.taotao.cart.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.cart.bean.Item;
import com.taotao.common.service.ApiService;

@Service
public class ItemServer {
	@Autowired
	private ApiService apiService;
	private ObjectMapper objectMapper = new ObjectMapper();
	@Value("${MANAGER_TAOTAO_URL}")
	private String MANAGER_TAOTAO_URL;
	public Item queryItemById(String itemId){
		try {
			String jsonStr = apiService.doGet(MANAGER_TAOTAO_URL+"/rest/api/item/"+itemId);
			return objectMapper.readValue(jsonStr, Item.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
