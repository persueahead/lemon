package com.taotao.web.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.httpclient.HttpResult;
import com.taotao.common.service.ApiService;
import com.taotao.sso.query.bean.User;
import com.taotao.web.bean.Order;
import com.taotao.web.threadlocal.UserThreadlocal;

@Service
public class OrderService {
	@Autowired
	private ApiService apiService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	@Value("${ORDER_TAOTAO_URL}")
	private String ORDER_TAOTAO_URL;
	public String submitOrder(Order order) {
		try {
			User user = UserThreadlocal.get();
			order.setUserId(user.getId());
			order.setBuyerNick(user.getUsername());
			
			String jsonStr = objectMapper.writeValueAsString(order);
			HttpResult result = apiService.doPostJson(ORDER_TAOTAO_URL+"/order/create",jsonStr);
			if(result.getCode() == 200){
				String content = result.getContent();
				JsonNode node = objectMapper.readTree(content);
				if(node.get("status").intValue() == 200){
					return node.get("data").textValue();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	/**
	 * 根据订单id查询订单信息
	 * @param orderId
	 * @return
	 */
	public Order queryOrderById(String orderId) {
		try {
			String jsonStr = apiService.doGet(ORDER_TAOTAO_URL+"/order/query/"+orderId);
			if(!StringUtils.isEmpty(jsonStr)){
				return objectMapper.readValue(jsonStr, Order.class);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
