package com.bjlemon.springboot.controller;

import com.bjlemon.springboot.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

}
