package com.bjlemon.jpa.service.impl;

import com.bjlemon.jpa.domain.Department;
import com.bjlemon.jpa.domain.User;
import com.bjlemon.jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:applicationContext.xml")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserListByName() {
        List<User> userList = this.userService.findUserListByName("zhangsan");
        userList.stream().forEach(System.out::println);
    }

    @Test
    public void authenticate() {
        User user = this.userService.authenticate("zhangsan", "admin");
        System.out.println(user);
    }

    @Test
    public void findDepartmentByUserName() {
        Department department = this.userService.findDepartmentByUserName("zhangsan");
        System.out.println(department);
    }

    @Test
    public void findUserListByNameAndSalaryScope() {
        List<User> userList = this.userService.findUserListByNameAndSalaryScope("s", Arrays.asList(20.00F, 40.00F));
        userList.stream().forEach(System.out::println);
    }

    @Test
    public void findDepartmentByUserName1() {
        Department department = this.userService.findDepartmentByUserName1("zhangsan","%B%");
        System.out.println(department);
    }

}