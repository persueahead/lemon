package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.User;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年03月03日 20:54:00
 */
public interface UserMapper {

    void save(User user);

    void delete(User user);

    void update(User user);

    User findById(Integer id);

    List<User> findAll();

}
