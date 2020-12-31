package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.User;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2019年12月26日 20:17:00
 */
public interface UserMapper {

    void save(User user);

    void delete(User user);

    void update(User user);

    User findById(Integer id);

    List<User> findAll();
}
