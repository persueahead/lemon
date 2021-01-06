package com.taotao.search.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.service.ApiService;
import com.taotao.search.bean.Item;

@Service
public class ItemServer {
	@Autowired
	private ApiService apiService;
	private ObjectMapper objectMapper = new ObjectMapper();
	public Item queryItemById(String itemId){
		try {
			String jsonStr = apiService.doGet("http://manager.taotao.com/rest/api/item/"+itemId);
			return objectMapper.readValue(jsonStr, Item.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
