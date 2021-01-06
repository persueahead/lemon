package com.blog.ln.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章管理的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/back/article/")
public class ArticleController {

	@RequestMapping("list")
	public String list() {
		return "back/article/article_list";
	}
	
	
	@RequestMapping("add")
	public String add() {
		return "back/article/article_add";
	}
}
