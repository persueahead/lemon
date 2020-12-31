package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Employee;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName EmployeeMapper.java
 * @Description TODO
 * @createTime 2020年03月03日 21:45:00
 */
public interface EmployeeMapper {

    List<Employee> findAll();
}
