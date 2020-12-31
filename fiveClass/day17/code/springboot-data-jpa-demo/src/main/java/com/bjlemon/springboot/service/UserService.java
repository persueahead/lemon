package com.bjlemon.springboot.service;

import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.vo.UserQueryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2020年01月14日 22:49:00
 */
public interface UserService {


    void addUser(User user);

    void deleteUser(User user);

    void modifyUser(User user);

    User findUserById(Integer id);

    List<User> findAllUserList();

    /**
     * @description 根据用户名称查询用户
     * @author admin
     * @updateTime 2020/1/16 21:37
     */
    List<User> findUserListByName(String name);

    List<User> findUserListByNameAndSalary(String name, Float salary);

    List<User> findUserListByNameAndSalary1(String name, Float salary);

    /**
     * @description 分页查询
     * @author admin
     * @updateTime 2020/1/16 20:18
     */
    Page<User> findUserPaginationList(PageRequest pageRequest);

    /**
     * @description 有条件的分页查询
     * @author admin
     * @updateTime 2020/1/18 20:04
     */
    Page<User> findUserPaginationList(PageRequest pageRequest, UserQueryVO userQueryVO);

    /**
     * @description 根据用户名称查询所在部门
     * @author admin
     * @updateTime 2020/1/16 22:17
     */
    Department findDepartmentByUserName(String name);

    User findUserByName(String name);
}
