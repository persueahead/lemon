package com.bjlemon.ssm.service.impl;

import com.bjlemon.ssm.domain.Employee;
import com.bjlemon.ssm.mapper.EmployeeMapper;
import com.bjlemon.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAllEmployeeList() {
        return this.employeeMapper.selectByExample(null);
    }
}
