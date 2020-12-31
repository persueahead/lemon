package com.bjlemon.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName FreeMarkerController.java
 * @Description TODO
 * @createTime 2020年01月07日 22:38:00
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @GetMapping("/helloworld")
    public String helloworld(Model model) {
        model.addAttribute("info", "Freemarker is very good");
        return "demo1";
    }
}
