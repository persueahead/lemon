package com.bjlemon.ssm.web.controller;

import com.bjlemon.ssm.domain.Employee;
import com.bjlemon.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @Controller + @ResponseBody
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAll")
    public List<Employee> findAll() {
        return this.employeeService.findAllEmployeeList();
    }

}
