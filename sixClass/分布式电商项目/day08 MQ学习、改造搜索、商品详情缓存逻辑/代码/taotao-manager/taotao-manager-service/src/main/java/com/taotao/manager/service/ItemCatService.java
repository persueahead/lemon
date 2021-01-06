package com.taotao.manager.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.abel533.mapper.Mapper;
import com.taotao.common.bean.ItemCatData;
import com.taotao.common.bean.ItemCatResult;
import com.taotao.common.service.RedisService;
import com.taotao.manager.mapper.ItemCatMapper;
import com.taotao.manager.pojo.ItemCat;

@Service
public class ItemCatService extends BaseService<ItemCat> {
	@Autowired
	private RedisService redisService;
	private static final String ITEM_CAT_KEY = "taotao_manager_item_cat_query_all_to_String";
	private static final int ITEM_CAT_KEY_TIME=60 * 60 * 24 * 30 * 3;
	private ObjectMapper mapper = new ObjectMapper();

	// @Autowired
	// public ItemCatMapper itemCatMapper;
	/* *//**
	 * 查询商品类目信息
	 * 
	 * @return
	 */
	/*
	 * public List<ItemCat> queryItemCatList(Long parentId) { ItemCat itemCat =
	 * new ItemCat(); itemCat.setParentId(parentId); return
	 * itemCatMapper.select(itemCat); }
	 */
	/*
	 * @Override public Mapper<ItemCat> getMapper() { // TODO Auto-generated
	 * method stub return itemCatMapper; }
	 */
	/**
	 * 全部查询，并且生成树状结构
	 * 
	 * @return
	 */
	public ItemCatResult queryAllToTree() {
		ItemCatResult result = new ItemCatResult();
		// 直接从缓存中取数据，如果有数据直接返回 key 命名 项目名_模块名_方法名（业务名称）
		try {
			String itemCatResultStr = redisService.get(ITEM_CAT_KEY);
			if (StringUtils.isNotBlank(itemCatResultStr)) {
				// 返回数据
				return mapper.readValue(itemCatResultStr, ItemCatResult.class);

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 全部查出，并且在内存中生成树形结构
		List<ItemCat> cats = queryAll();
		// 转为map存储，key为父节点ID，value为数据集合
		Map<Long, List<ItemCat>> itemCatMap = new HashMap<Long, List<ItemCat>>();
		for (ItemCat itemCat : cats) {
			if (!itemCatMap.containsKey(itemCat.getParentId())) {
				itemCatMap.put(itemCat.getParentId(), new ArrayList<ItemCat>());
			}
			itemCatMap.get(itemCat.getParentId()).add(itemCat);
		}

		// 封装一级对象
		List<ItemCat> itemCatList1 = itemCatMap.get(0L);
		for (ItemCat itemCat : itemCatList1) {
			ItemCatData itemCatData = new ItemCatData();
			itemCatData.setUrl("/products/" + itemCat.getId() + ".html");
			itemCatData.setName("<a href='" + itemCatData.getUrl() + "'>"
					+ itemCat.getName() + "</a>");
			result.getItemCats().add(itemCatData);
			if (!itemCat.getIsParent()) {
				continue;
			}

			// 封装二级对象
			List<ItemCat> itemCatList2 = itemCatMap.get(itemCat.getId());
			List<ItemCatData> itemCatData2 = new ArrayList<ItemCatData>();
			itemCatData.setItems(itemCatData2);
			for (ItemCat itemCat2 : itemCatList2) {
				ItemCatData id2 = new ItemCatData();
				id2.setName(itemCat2.getName());
				id2.setUrl("/products/" + itemCat2.getId() + ".html");
				itemCatData2.add(id2);
				if (itemCat2.getIsParent()) {
					// 封装三级对象
					List<ItemCat> itemCatList3 = itemCatMap.get(itemCat2
							.getId());
					List<String> itemCatData3 = new ArrayList<String>();
					id2.setItems(itemCatData3);
					for (ItemCat itemCat3 : itemCatList3) {
						itemCatData3.add("/products/" + itemCat3.getId()
								+ ".html|" + itemCat3.getName());
					}
				}
			}
			if (result.getItemCats().size() >= 14) {
				break;
			}
		}
		// 将result存储到redis中
		try {
			redisService.set(ITEM_CAT_KEY, mapper.writeValueAsString(result),ITEM_CAT_KEY_TIME);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
