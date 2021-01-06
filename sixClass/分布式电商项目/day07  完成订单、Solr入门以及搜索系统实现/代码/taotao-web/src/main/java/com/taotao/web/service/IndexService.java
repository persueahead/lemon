package com.taotao.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;




import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.taotao.common.bean.EasyUIResult;
import com.taotao.common.service.ApiService;
import com.taotao.manager.pojo.Content;

@Service
public class IndexService {
	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private ApiService apiService;
	@Value("${MANAGER_TAOTAO_URL}")
	private String MANAGER_TAOTAO_URL;
	@Value("${INDEX_AD1_URL}")
	private String INDEX_AD1_URL;
	@Value("${INDEX_AD2_URL}")
	private String INDEX_AD2_URL;
	/**
	 * 查询大广告位的数据
	 * @return
	 */
	public String queryIndexAd1() {
		try {
			
			String str = apiService.doGet(MANAGER_TAOTAO_URL+INDEX_AD1_URL);
			EasyUIResult result = EasyUIResult.formatToList(str, Content.class);
			List<Content> rows = (List<Content>) result.getRows();
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			if(null != rows && rows.size() > 0){
				for(Content content:rows){
					Map<String,Object> map = new LinkedHashMap<String, Object>();
					map.put("srcB", content.getPic());
					map.put("height", 240);
					map.put("alt", content.getTitle());
					map.put("width", 670);
					map.put("src", content.getPic());
					map.put("widthB", 550);
					map.put("href", content.getUrl());
					map.put("heightB", 240);
					list.add(map);
				}
			}
			return mapper.writeValueAsString(list);
			
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
	 * 查询小广告位数据
	 * @return
	 */
	public String queryIndexAd2() {
		try {
			String str = apiService.doGet(MANAGER_TAOTAO_URL+INDEX_AD2_URL);
			EasyUIResult result = EasyUIResult.formatToList(str, Content.class);
			List<Content> rows = (List<Content>) result.getRows();
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			if(null != rows && rows.size() > 0){
				for(Content content:rows){
					Map<String,Object> map = new LinkedHashMap<String, Object>();
					map.put("width", 310);
					map.put("height", 70);
					map.put("src", content.getPic());
					map.put("href", content.getUrl());
					map.put("alt", content.getTitle());
					map.put("widthB", 210);
					map.put("heightB", 70);
					map.put("srcB", content.getPic());
					list.add(map);
				}
			}
			return mapper.writeValueAsString(list);
			
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
