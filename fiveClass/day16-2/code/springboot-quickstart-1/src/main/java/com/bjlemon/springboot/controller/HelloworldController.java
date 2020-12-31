package com.bjlemon.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloworldController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Helloworld Spring Boot";
    }
}
