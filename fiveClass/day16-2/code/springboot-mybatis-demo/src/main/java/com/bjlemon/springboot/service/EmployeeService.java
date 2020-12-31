package com.bjlemon.springboot.service;

import com.bjlemon.springboot.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployeeList();
}
