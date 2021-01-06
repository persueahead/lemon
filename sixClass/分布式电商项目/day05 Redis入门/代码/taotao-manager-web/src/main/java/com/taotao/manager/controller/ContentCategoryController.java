package com.taotao.manager.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.manager.pojo.ContentCategory;
import com.taotao.manager.service.ContentCategoryService;

@RequestMapping("content/category")
@Controller
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCategoryService;
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ContentCategory>> queryContentCategoryList(
			@RequestParam(value="id",defaultValue="0",required=false)Long pid){
		try {
			ContentCategory record = new ContentCategory();
			record.setParentId(pid);
			List<ContentCategory> list = contentCategoryService.queryListByWhere(record);
			if(null == list || list.size() == 0){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<ContentCategory> saveContentCategory(@RequestParam(value="name")String name,
			@RequestParam("parentId")Long parentId){
		try {
			ContentCategory record = new ContentCategory();
			record.setCreated(new Date());
			record.setIsParent(false);
			record.setName(name);
			record.setParentId(parentId);
			record.setSortOrder(1);
			record.setStatus(1);
			record.setUpdated(record.getCreated());
			contentCategoryService.saveContentCategory(record);
			return ResponseEntity.status(HttpStatus.CREATED).body(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> updateContentCategory(@RequestParam("id")Long id,
			@RequestParam("name")String name){
		try {
			ContentCategory record = new ContentCategory();
			record.setId(id);
			record.setName(name);
			contentCategoryService.updateSelective(record);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteContentCategory(@RequestParam("parentId")Long parentId,
			@RequestParam("id")Long id){
		try {
			contentCategoryService.deleteAll(parentId,id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
