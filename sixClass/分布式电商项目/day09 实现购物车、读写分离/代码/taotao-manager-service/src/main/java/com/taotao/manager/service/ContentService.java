package com.taotao.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.bean.EasyUIResult;
import com.taotao.manager.mapper.ContentMapper;
import com.taotao.manager.pojo.Content;
@Service
public class ContentService extends BaseService<Content> {
	@Autowired
	private ContentMapper contentMapper;
	public EasyUIResult queryContentByCategoryId(Long categoryId, Integer page,
			Integer rows) {
		PageHelper.startPage(page, rows);
		List<Content> contents = contentMapper.queryContentByCategoryId(categoryId);
		PageInfo<Content> info = new PageInfo<Content>(contents);
		return new EasyUIResult(info.getTotal(), info.getList());
	}

}
