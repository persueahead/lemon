package com.bjlemon.springboot.service.impl;

import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年01月07日 22:49:00
 */
@Service
public class UserServiceImpl implements UserService {

    private static List<User> userList;

    static {
        User user1 = new User();
        user1.setId(1);
        user1.setName("zhangsan");
        user1.setPassword("admin");
        user1.setSalary(12.34F);
        user1.setBirthday(new Date());

        User user2 = new User();
        user2.setId(2);
        user2.setName("lisi");
        user2.setPassword("admin");
        user2.setSalary(12.34F);
        user2.setBirthday(new Date());

        User user3 = new User();
        user3.setId(3);
        user3.setName("wangwu");
        user3.setPassword("admin");
        user3.setSalary(12.34F);
        user3.setBirthday(new Date());

        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    @Override
    public List<User> findAll() {
        return userList;
    }
}
