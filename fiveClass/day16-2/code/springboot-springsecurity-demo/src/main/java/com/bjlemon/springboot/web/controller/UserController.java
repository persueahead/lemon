package com.bjlemon.springboot.web.controller;

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
 * @createTime 2020年02月15日 21:54:00
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/add")
    @ResponseBody
//    @Secured({"ROLE_ADMIN"})
//    @PreAuthorize(value = "hasAuthority('user:add')")
    @PreAuthorize(value = "hasAuthority('user:add')")
    public String add() {
        System.out.println("add");
        return "success";
    }

    @GetMapping("/delete")
    @ResponseBody
//    @Secured({"ROLE_ADMIN"})
    @PreAuthorize(value = "hasAuthority('user:delete')")
    public String delete() {
        System.out.println("delete");
        return "success";
    }

    @GetMapping("/update")
//    @Secured({"ROLE_ADMIN"})
    @ResponseBody
    @PreAuthorize(value = "hasAuthority('user:update')")
    public String update() {
        System.out.println("update");
        return "success";
    }

    @GetMapping("/findAll")
    @ResponseBody
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
//    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String findAll() {
        System.out.println("findAll");
        return "success";
    }

}
