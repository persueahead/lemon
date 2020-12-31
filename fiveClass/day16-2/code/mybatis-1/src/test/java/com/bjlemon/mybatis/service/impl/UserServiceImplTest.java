package com.bjlemon.mybatis.service.impl;

import com.bjlemon.mybatis.domain.User;
import com.bjlemon.mybatis.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserServiceImplTest.java
 * @Description TODO
 * @createTime 2020年02月29日 22:52:00
 */
public class UserServiceImplTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        this.userService = new UserServiceImpl();
    }

    @Test
    public void testAddUser() {
        /*User.builder().name("zhangsan")
                .password("admin")
                .salary(12.34F)
                .birthday(new Date());*/

        User user = new User();
        user.setName("zhangsan");
        user.setPassword("password");
        user.setSalary(12.34F);
        user.setBirthday(new Date());

        this.userService.addUser(user);
    }

    @Test
    public void testDeleteUser() {
        User user = this.userService.findUserById(2);
        this.userService.deleteUser(user);
    }

    @Test
    public void testModifyUser() {
        User user = this.userService.findUserById(3);
        user.setName("C罗");
        user.setPassword("123456");
        this.userService.modifyUser(user);
    }

    @Test
    public void findUserById() {
    }

    @Test
    public void testFindAllUserList() {
        this.userService.findAllUserList().stream().forEach(System.out::println);
    }
}