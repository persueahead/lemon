package com.bjlemon.mybatis.service;

import com.bjlemon.mybatis.domain.User;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2020年02月29日 22:24:00
 */
public interface UserService {

    void addUser(User user);

    void deleteUser(User user);

    void modifyUser(User user);

    User findUserById(Integer id);

    List<User> findAllUserList();
}
