package com.taotao.manager.controller.api;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.bean.ItemCatResult;
import com.taotao.manager.service.ItemCatService;

@Controller
@RequestMapping("api/item/cat")
public class ApiItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	private ObjectMapper objectMapper = new ObjectMapper();
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ItemCatResult> queryAll(){
		try {
			ItemCatResult result = itemCatService.queryAllToTree();
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

}
