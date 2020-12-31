package com.bjlemon.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bjlemon.springboot.domain.User;

import java.util.List;

public interface UserService {

    IPage<User> findUserPaginationList(Integer pageNum, Integer pageSize);

    /**
     * 根据部门名称查询该部门的用户列表
     * @param name
     * @return
     */
    List<User> findUserListByDepartmentName(String name);

    /**
     * 根据部门名称查询该部门的用户列表
     * @param name
     * @return
     */
    List<User> findUserListByDepartmentName1(String name);

    void addUser(User user);

    void deleteUser(User user);

    void modifyUser(User user);

    User findUserById(Integer id);

    List<User> findAllUserList();
}
