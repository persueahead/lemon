package com.bjlemon.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName HelloworldController.java
 * @Description TODO
 * @createTime 2020年01月02日 22:21:00
 */
@Controller
public class HelloworldController {

    @GetMapping("/sayHello")
    @ResponseBody
    public String sayHello() {
//        return "Helloworld SpringBoot";
        return "你好SpringBoot";
    }
}
