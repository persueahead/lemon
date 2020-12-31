package com.bjlemon.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName JspController.java
 * @Description TODO
 * @createTime 2020年01月07日 20:46:00
 */
@Controller
@RequestMapping("/jsp")
public class JspController {

    @GetMapping("/helloworld")
    public String helloworld(Model model) {
        model.addAttribute("info", "SpringBoot整合JSP");
        return "helloworld";
    }
}
