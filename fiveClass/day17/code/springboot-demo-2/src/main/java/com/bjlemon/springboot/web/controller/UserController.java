package com.bjlemon.springboot.web.controller;

import com.bjlemon.springboot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年01月02日 22:31:00
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add")
    @ResponseBody
    public User add(@RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
