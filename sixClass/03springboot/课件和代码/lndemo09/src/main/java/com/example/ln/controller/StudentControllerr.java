package com.example.ln.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ln.po.Student;

@Controller
@RequestMapping("/stu/")
public class StudentControllerr {

	@RequestMapping("hello")
	public String hello(Model model) {

		model.addAttribute("hello", "你好 thymeleaf");
		return "student";
	}

	@RequestMapping("find")
	public String findStudent(Model model) {

		Student stu = new Student();
		stu.setId(9527);
		stu.setName("华安");
		stu.setSex("男");
		stu.setAge(22);

		// 返回到页面上显示
		model.addAttribute("stu", stu);

		return "student";
	}

	@RequestMapping("list")
	public String list(Model model) {

		List<Student> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Student stu = new Student();
			stu.setId(9527 + i);
			stu.setName("华安" + i);
			if (i % 2 == 0) {
				stu.setSex("男");
			} else {
				stu.setSex("女");
			}

			stu.setAge(22 + i);

			list.add(stu);
		}

		// 把多个的学生信息返回到页面
		model.addAttribute("list", list);

		return "stu_list";

	}

	@RequestMapping("url")
	public String url(Model model) {
		model.addAttribute("aurl", "http://www.51cto.com");
		model.addAttribute("imgurl", "/img/f1.jpg");
		model.addAttribute("id", "9530");

		List<Student> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Student stu = new Student();
			stu.setId(9527 + i);
			stu.setName("华安" + i);
			if (i % 2 == 0) {
				stu.setSex("男");
			} else {
				stu.setSex("女");
			}

			stu.setAge(22 + i);

			list.add(stu);
		}

		model.addAttribute("list", list);

		return "url";
	}
}
