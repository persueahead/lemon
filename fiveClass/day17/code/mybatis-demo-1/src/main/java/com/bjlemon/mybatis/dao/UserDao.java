package com.bjlemon.mybatis.dao;

import com.bjlemon.mybatis.domain.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    void delete(User user);

    void update(User user);

    User findById(Integer id);

    List<User> findAll();
}
