package com.taotao.manager.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.common.bean.EasyUIResult;
import com.taotao.manager.pojo.Content;
import com.taotao.manager.service.ContentService;

@Controller
@RequestMapping("content")
public class ApiContentController {
	@Autowired
	private ContentService contentService;
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>  saveContent(Content content){
		try {
			content.setId(null);
			contentService.save(content);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<EasyUIResult> queryContentByCategoryId(
			@RequestParam("categoryId")Long categoryId,@RequestParam(value="page",defaultValue="1")Integer page
			,@RequestParam("rows")Integer rows){
		try {
			EasyUIResult result = contentService.queryContentByCategoryId(categoryId,page,rows);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
}
