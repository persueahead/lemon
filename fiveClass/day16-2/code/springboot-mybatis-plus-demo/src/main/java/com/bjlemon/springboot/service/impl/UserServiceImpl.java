package com.bjlemon.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.mapper.UserMapper;
import com.bjlemon.springboot.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> findUserPaginationList(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0) {
            throw new IllegalArgumentException("");
        }

        if (pageSize == null || pageSize <= 0) {
            throw new IllegalArgumentException("");
        }

        IPage page = new Page(pageNum, pageSize);
        return this.userMapper.selectPage(page, null);
    }

    @Override
    public List<User> findUserListByDepartmentName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("");
        }

        return this.userMapper.findUsersByDepartmentName(name);
    }

    @Override
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userMapper.insert(user);
    }

    @Override
    public void deleteUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userMapper.deleteById(user.getId());
    }

    @Override
    public void modifyUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userMapper.updateById(user);
    }

    @Override
    public User findUserById(Integer id) {
        return this.userMapper.selectById(id);
    }

    @Override
    public List<User> findAllUserList() {
        return this.userMapper.selectList(null);
    }

    @Override
    public List<User> findUserListByDepartmentName1(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("");
        }

        return this.userMapper.findUserListByDepartmentName1(name);
    }


}
