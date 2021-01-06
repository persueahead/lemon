package com.taotao.web.mq.handler;


import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.service.RedisService;
import com.taotao.web.service.ItemService;

public class RabbitMqHanler {
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private RedisService redisService;
	public void hand(String msg){
		//删除redis中的商品的缓存数据
		try {
			JsonNode node = objectMapper.readTree(msg);
			Long itemId = node.get("id").asLong();
			String key = ItemService.KEY+"_"+itemId;
			redisService.del(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
