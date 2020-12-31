package com.bjlemon.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("info","SpringBoot整合JSP");
        return "index";
    }
}
