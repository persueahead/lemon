package com.bjlemon.ssm.web.controller;

import com.bjlemon.ssm.domain.User;
import com.bjlemon.ssm.service.UserService;
import com.bjlemon.ssm.vo.UserQueryVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {
        return this.userService.findAllUserList();
    }

    @GetMapping("/findPagination/{pageNum}/{pageSize}")
    @ResponseBody
    public PageInfo<User> findPagination(@PathVariable Integer pageNum,
                                         @PathVariable Integer pageSize) {
        return this.userService.findUserPaginationList(pageNum, pageSize);
    }

    @GetMapping("/findUserPaginationListByCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public PageInfo<User> findUserPaginationListByCondition(@PathVariable Integer pageNum,
                                                            @PathVariable Integer pageSize,
                                                            @RequestBody UserQueryVO userQueryVO) {
        return this.userService.findUserPaginationListByCondition(pageNum, pageSize, userQueryVO);
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(User user) {
//        System.out.println(user);
        this.userService.addUser(user);
        return "success";
    }
}
