package com.bjlemon.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("info", "Helloworld Freemarker");
        model.addAttribute("inters", Arrays.asList("football","basketball","volleyball"));
        return "demo";
    }
}
