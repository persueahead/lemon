package com.bjlemon.ssm.service.impl;

import com.bjlemon.ssm.domain.Employee;
import com.bjlemon.ssm.mapper.EmployeeMapper;
import com.bjlemon.ssm.service.EmployeeService;
import com.bjlemon.ssm.vo.EmployeeVO;
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

    @Override
    public Employee findEmployeeById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("");
        }

        return this.employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public EmployeeVO findEmployeeVOById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("");
        }

        return this.employeeMapper.findEmployeeVOById(id);
    }
}
