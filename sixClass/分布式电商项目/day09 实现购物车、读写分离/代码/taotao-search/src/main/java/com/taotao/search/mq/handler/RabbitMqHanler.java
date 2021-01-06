package com.taotao.search.mq.handler;

import java.io.IOException;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.search.bean.Item;
import com.taotao.search.service.ItemServer;

public class RabbitMqHanler {
	
	private ObjectMapper objectMapper =new ObjectMapper();
	@Autowired
	private HttpSolrServer httpSolrServer;
	@Autowired
	private ItemServer itemServer;
	/**
	 *  新增，更改，删除
	 * @param msg
	 */
	public void hand(String msg){
		try {
			JsonNode node = objectMapper.readTree(msg);
			Long itemId = node.get("id").asLong();
			String type = node.get("type").asText();
			if("update".equals(type)|| "insert".equals(type)){
				Item item = itemServer.queryItemById(String.valueOf(itemId));
				httpSolrServer.addBean(item);
				httpSolrServer.commit();
			}else if("delete".equals("type")){
				httpSolrServer.deleteById(String.valueOf(itemId));
				httpSolrServer.commit();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
