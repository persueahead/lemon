package com.bjlemon.mybatis.service;

import com.bjlemon.mybatis.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(User user);

    void modifyUser(User user);

    User findUserById(Integer id);

    List<User> findAllUserList();
}
