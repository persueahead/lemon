package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Employee;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName EmployeeMapper.java
 * @Description TODO
 * @createTime 2019年12月26日 21:17:00
 */
public interface EmployeeMapper {

    List<Employee> findAll();

    Employee findById(Integer id);

    void update(Employee employee);

    Employee getById(Integer id);
}
