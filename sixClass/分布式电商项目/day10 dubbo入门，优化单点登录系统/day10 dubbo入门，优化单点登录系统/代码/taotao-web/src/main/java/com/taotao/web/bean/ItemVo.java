package com.taotao.web.bean;

import org.apache.commons.lang3.StringUtils;

import com.taotao.manager.pojo.Item;

public class ItemVo extends Item{

	public String[] getImages(){
		return StringUtils.split(super.getImage(),"," );
	}
}
