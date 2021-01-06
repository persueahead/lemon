package com.blog.ln.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 留言管理的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/back/message/")
public class MessageController {

	
	@RequestMapping("list")
	public String list() {
		return "back/message/message_list";
	}
	
	@RequestMapping("update")
	public String add() {
		return "back/message/message_update";
	}
}
