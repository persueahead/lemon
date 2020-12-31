package com.bjlemon.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloworldController {

    @GetMapping("/sayHello")
    @ResponseBody
    public String sayHello() {
        return "Helloworld Spring Boot";
    }
}
