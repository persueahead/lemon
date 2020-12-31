package com.bjlemon.security.dao;

import com.bjlemon.security.domain.User;

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
