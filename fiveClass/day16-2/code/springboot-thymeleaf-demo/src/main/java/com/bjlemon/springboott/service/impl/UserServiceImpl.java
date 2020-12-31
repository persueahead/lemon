package com.bjlemon.springboott.service.impl;

import com.bjlemon.springboott.domain.User;
import com.bjlemon.springboott.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<>();

    static {
        User user1 = new User(1,"zhangsan","admin",12.34F,new Date());
        User user2 = new User(2,"lisi","admin",45.34F,new Date());
        User user3 = new User(3,"wangwu","admin",77.34F,new Date());
        User user4 = new User(4,"C罗","admin",99.34F,new Date());
        User user5 = new User(5,"梅西","admin",88.34F,new Date());

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
    }

    @Override
    public List<User> findAllUserList() {
        return userList;
    }
}
