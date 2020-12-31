package com.bjlemon.mybatis.service.impl;

import com.bjlemon.mybatis.domain.User;
import com.bjlemon.mybatis.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class UserServiceImplTest {

    private UserService userService;

    /**
     * 执行单元测试方法之前运行该方法
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        this.userService = new UserServiceImpl();
    }

    @Test
    public void testAddUser() {
        User user = User.builder()
                .name("zhangsan")
                .password("admin")
                .salary(12.34F)
                .birthday(new Date())
                .build();
        this.userService.addUser(user);
    }

    @Test
    public void testDeleteUser() {
        User user = this.userService.findUserById(5);
        this.userService.deleteUser(user);
    }

    @Test
    public void testModifyUser() {
        User user = this.userService.findUserById(4);
        user.setName("abc");
        user.setPassword("123456");

        this.userService.modifyUser(user);
    }

    @Test
    public void findUserById() {

    }

    @Test
    public void findAllUserList() {
        this.userService.findAllUserList().stream().forEach(System.out::println);
    }
}