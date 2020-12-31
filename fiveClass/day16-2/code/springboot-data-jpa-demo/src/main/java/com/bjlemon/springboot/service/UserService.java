package com.bjlemon.springboot.service;



import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.domain.User;

import java.util.List;

public interface UserService {

    List<User> findUserListByName(String name);

    User authenticate(String name, String password);

    Department findDepartmentByUserName(String name);

    List<User> findUserListByNameAndSalaryScope(String name, List<Float> salaryScopeList);

    /**
     * 根据用户名称查询出部门名有“B”的部门
     * @param userName
     * @param departmentName
     * @return
     */
    Department findDepartmentByUserName1(String userName, String departmentName);
}
