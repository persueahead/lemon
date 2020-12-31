package com.bjlemon.springboot.dao;

import com.bjlemon.springboot.domain.User;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserDao.java
 * @Description TODO
 * @createTime 2020年02月11日 22:12:00
 */
public interface UserDao {

    User findByName(String name);
}
