package com.bjlemon.mybatis.dao;

import com.bjlemon.mybatis.domain.User;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserDao.java
 * @Description TODO
 * @createTime 2020年02月29日 22:23:00
 */
public interface UserDao {

    void save(User user);

    void delete(User user);

    void update(User user);

    User findById(Integer id);

    List<User> findAll();
}
