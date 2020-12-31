package com.bjlemon.mybatis.service.impl;

import com.bjlemon.mybatis.dao.UserDao;
import com.bjlemon.mybatis.dao.impl.UserDaoImpl;
import com.bjlemon.mybatis.domain.User;
import com.bjlemon.mybatis.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userDao.save(user);
    }

    @Override
    public void deleteUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userDao.delete(user);
    }

    @Override
    public void modifyUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userDao.update(user);
    }

    @Override
    public User findUserById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("");
        }

        return this.userDao.findById(id);
    }

    @Override
    public List<User> findAllUserList() {
        return this.userDao.findAll();
    }
}
