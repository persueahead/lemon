package com.bjlemon.springboot.web.controller;

import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年01月07日 22:47:00
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<User> userList = this.userService.findAll();
        model.addAttribute("userList", userList);
        return "list";
    }

}
