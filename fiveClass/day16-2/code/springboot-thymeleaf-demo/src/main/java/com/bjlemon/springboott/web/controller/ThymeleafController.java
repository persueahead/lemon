package com.bjlemon.springboott.web.controller;

import com.bjlemon.springboott.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/test2")
    public String test2(Model model) {
        User user = User.builder()
                        .id(1)
                        .name("zhangsan")
                        .password("admin")
                        .salary(12.34F)
                        .birthday(new Date())
                        .build();

        model.addAttribute("user",user);
        return "test2";

    }

    @GetMapping("/test3")
    public String test3(Model model) {
        model.addAttribute("id",1000);
        return "test3";

    }
}
