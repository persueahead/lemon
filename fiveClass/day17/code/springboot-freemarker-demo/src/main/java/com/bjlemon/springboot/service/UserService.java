package com.bjlemon.springboot.service;

import com.bjlemon.springboot.domain.User;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2020年01月07日 22:48:00
 */
public interface UserService {

    List<User> findAll();
}
