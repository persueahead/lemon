package com.bjlemon.mybatis.service.impl;

import com.bjlemon.mybatis.dao.UserDao;
import com.bjlemon.mybatis.dao.impl.UserDaoImpl;
import com.bjlemon.mybatis.domain.User;
import com.bjlemon.mybatis.service.UserService;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月29日 22:24:00
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userDao.save(user);
    }

    public void deleteUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userDao.delete(user);
    }

    public void modifyUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userDao.update(user);
    }

    public User findUserById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("");
        }

        return this.userDao.findById(id);
    }

    public List<User> findAllUserList() {
        return this.userDao.findAll();
    }
}
