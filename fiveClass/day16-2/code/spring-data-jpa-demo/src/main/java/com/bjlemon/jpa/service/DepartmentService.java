package com.bjlemon.jpa.service;

import com.bjlemon.jpa.domain.Department;
import com.bjlemon.jpa.domain.User;

import java.util.List;

public interface DepartmentService {

    void addDepartment(Department department);

    void deleteDepartment(Department department);

    void modifyDepartment(Department department);

    Department findDepartmentById(Integer id);

    List<Department> findAllDepartmentList();

    List<User> findAllUserListByDepartmentName(String name);
}
