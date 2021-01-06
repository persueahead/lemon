package com.blog.ln.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 栏目管理的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/back/category/")
public class CategoryController {
	
	@RequestMapping("list")
	public String list() {
		return "back/category/category";
	}
	
	@RequestMapping("update")
	public String add() {
		return "back/category/category_update";
	}

}
