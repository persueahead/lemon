package com.bjlemon.springboot.service;


import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.domain.User;

import java.util.List;

public interface DepartmentService {

    void addDepartment(Department department);

    void deleteDepartment(Department department);

    void modifyDepartment(Department department);

    Department findDepartmentById(Integer id);

    List<Department> findAllDepartmentList();

    List<User> findAllUserListByDepartmentName(String name);
}
