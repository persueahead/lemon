package com.bjlemon.springboott.web.controller;

import com.bjlemon.springboott.domain.User;
import com.bjlemon.springboott.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<User> userList = this.userService.findAllUserList();
        model.addAttribute("userList",userList);
        return "test1";
    }


}
