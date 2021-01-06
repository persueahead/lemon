package com.taotao.web.service;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.taotao.common.service.RedisService;
import com.taotao.manager.pojo.ItemDesc;
import com.taotao.web.bean.ItemVo;

@Service
public class ItemService {
	@Value("${MANAGER_TAOTAO_URL}")
	private String MANAGER_TAOTAO_URL;
	@Autowired
	private ApiService apiService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private RedisService redisService;
	
	private static final String KEY = "taotao_web_item_detail";
	private static final int SECOND = 60*60*24;
	public ItemVo queryItemById(Long itemId) {
		
		try {
			String itemStr = redisService.get(KEY+"_"+itemId);
			if(StringUtils.isNotEmpty(itemStr)){
				return objectMapper.readValue(itemStr, ItemVo.class);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String itemJson = apiService.doGet(MANAGER_TAOTAO_URL+"/rest/api/item/"+itemId);
			ItemVo item = objectMapper.readValue(itemJson, ItemVo.class);
			
			try {
				redisService.set(KEY+"_"+itemId, itemJson, SECOND);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return item;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ItemDesc queryItemDescById(Long itemId) {
		try {
			String itemDescJson = apiService.doGet(MANAGER_TAOTAO_URL+"/rest/api/item/desc/"+itemId);
			if(StringUtils.isNoneBlank(itemDescJson)){
				ItemDesc itemDesc = objectMapper.readValue(itemDescJson, ItemDesc.class);
				return itemDesc;
			}
			return null;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据商品的id查询商品规格数据
	 * @param itemId
	 * @return
	 */
	public String queryItemParamItemByItemId(Long itemId) {
		try {
			String itemparamItemStr = apiService.doGet(MANAGER_TAOTAO_URL+"/rest/api/item/param/item/"+itemId);
			JsonNode rootNode = objectMapper.readTree(itemparamItemStr);
			String paramData = rootNode.get("paramData").asText();
			ArrayNode arr = (ArrayNode) objectMapper.readTree(paramData);
			StringBuilder sb = new StringBuilder();
			sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"ptable\"><tbody>");
			for(JsonNode node:arr){
				sb.append("<tr><th class=\"tdTitle\" colspan=\"2\">"+node.get("group").asText()+"</th></tr>");
				ArrayNode params =  (ArrayNode) node.get("params");
				for(JsonNode param:params){
					sb.append("<tr><td class=\"tdTitle\">"+param.get("k").asText()+"</td><td>"+param.get("v").asText()+"</td></tr>");
				}
			}
			sb.append("</tbody></table>");
			return sb.toString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
