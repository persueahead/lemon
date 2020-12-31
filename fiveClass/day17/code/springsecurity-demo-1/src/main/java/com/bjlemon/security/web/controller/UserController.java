package com.bjlemon.security.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年01月18日 22:37:00
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/list")
    public String list() {
        System.out.println("查询列表");
        return "list";
    }

    @GetMapping("/add")
    @ResponseBody
    @Secured({"ROLE_ADMIN"})
    public String add() {
        System.out.println("add");
        return "success";
    }

    @GetMapping("/delete")
    @ResponseBody
    @Secured({"ROLE_ADMIN"})
    public String delete() {
        System.out.println("delete");
        return "success";
    }

    @GetMapping("/edit")
//    @Secured({"ROLE_ADMIN"})
    @ResponseBody
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public String edit() {
        System.out.println("edit");
        return "success";
    }

    @GetMapping("/findAll")
    @ResponseBody
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String findAll() {
        System.out.println("findAll");
        return "success";
    }

}
