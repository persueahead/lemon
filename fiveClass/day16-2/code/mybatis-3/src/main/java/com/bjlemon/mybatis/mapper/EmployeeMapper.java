package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Department;
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

    void save(Employee employee);

    List<Employee> findEmployeesByDepartmentId(Integer departmentId);

    /**
     * @description 根据员工名称查询所在部门
     * @author admin
     * @updateTime 2020/3/3 22:53
     */
    Department findDepartmentByName(String name);
}
