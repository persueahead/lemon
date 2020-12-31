package com.bjlemon.ssm.service.impl;

import com.bjlemon.ssm.domain.User;
import com.bjlemon.ssm.domain.UserExample;
import com.bjlemon.ssm.mapper.UserMapper;
import com.bjlemon.ssm.service.UserService;
import com.bjlemon.ssm.vo.UserQueryVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUserList() {
        List<User> userList = Collections.emptyList();
        UserExample userExample = new UserExample();
        userList = this.userMapper.selectByExample(userExample);
        return userList;
    }

    public PageInfo<User> findUserPaginationList(Integer pageNum, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(pageNum, pageSize);

        UserExample userExample = new UserExample();
        List<User> userList = this.userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);

        return pageInfo;
    }

    public PageInfo<User> findUserPaginationListByCondition(Integer pageNum, Integer pageSize,
                                                            UserQueryVO userQueryVO) {
        PageInfo<User> pageInfo = null;

        if (pageNum == null || pageNum <= 0) {
            throw new IllegalArgumentException("");
        }

        if (pageSize == null || pageSize <= 0) {
            throw new IllegalArgumentException("");
        }

        if (userQueryVO == null) {
            return this.findUserPaginationList(pageNum, pageSize);
        }

        PageHelper.startPage(pageNum, pageSize);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        String userName = userQueryVO.getUserName();
        String userPassword = userQueryVO.getUserPassword();
        Float userSalary = userQueryVO.getUserSalary();
        Date userBirthday = userQueryVO.getUserBirthday();
        Integer departmentId = userQueryVO.getDepartmentId();

        if (StringUtils.isNotBlank(userName)) {
            criteria.andUserNameLike("%" + userName + "%");
        }

        if (StringUtils.isNotBlank(userPassword)) {
            criteria.andUserPasswordLike("%" + userPassword + "%");
        }

        if (userSalary != null && userSalary > 0.0F) {
            criteria.andUserSalaryEqualTo(userSalary);
        }

        if (userBirthday != null) {
            criteria.andUserBirthdayEqualTo(userBirthday);
        }

        if (departmentId != null && departmentId > 0) {
            criteria.andDepartmentIdEqualTo(departmentId);
        }

        List<User> userList = this.userMapper.selectByExample(userExample);
        return new PageInfo<User>(userList);
    }

    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userMapper.insertSelective(user);
    }
}
