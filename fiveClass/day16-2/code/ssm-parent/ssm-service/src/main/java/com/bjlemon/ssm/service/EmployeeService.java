package com.bjlemon.ssm.service;

import com.bjlemon.ssm.domain.Employee;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentService.java
 * @Description TODO
 * @createTime 2020年03月07日 22:53:00
 */
public interface EmployeeService {

    List<Employee> findAllEmployeeList();
}
