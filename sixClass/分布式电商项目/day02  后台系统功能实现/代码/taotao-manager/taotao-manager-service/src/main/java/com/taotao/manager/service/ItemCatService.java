package com.taotao.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.mapper.Mapper;
import com.taotao.manager.mapper.ItemCatMapper;
import com.taotao.manager.pojo.ItemCat;

@Service
public class ItemCatService extends BaseService<ItemCat>{

	//@Autowired
	//public ItemCatMapper itemCatMapper;
   /* *//**
     * 查询商品类目信息
     * @return
     *//*
	public List<ItemCat> queryItemCatList(Long parentId) {
		ItemCat itemCat = new ItemCat();
		itemCat.setParentId(parentId);
		return itemCatMapper.select(itemCat);
	}*/
	/*@Override
	public Mapper<ItemCat> getMapper() {
		// TODO Auto-generated method stub
		return itemCatMapper;
	}*/
	
}
