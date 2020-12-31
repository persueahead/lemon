package com.bjlemon.springboot.service;

import com.bjlemon.springboot.domain.Department;

public interface DepartmentService {

    /**
     * 根据部门名称查询部门
     * @param name
     * @return
     */
    Department findDepartmentByName(String name);

    Department findDepartmentByName1(String name);

}
