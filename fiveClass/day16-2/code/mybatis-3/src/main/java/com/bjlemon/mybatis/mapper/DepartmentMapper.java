package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Department;
import com.bjlemon.mybatis.domain.Employee;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentMapper.java
 * @Description TODO
 * @createTime 2020年03月03日 21:45:00
 */
public interface DepartmentMapper {

    /**
     * @description 根据部门名称查询部门，同时将员工也查询出来
     * @author admin
     * @updateTime 2020/3/3 22:30
     */
    Department findByDepartmentName(String name);

    /**
     * @description 根据部门名称查询部门，同时将员工也查询出来
     * @author admin
     * @updateTime 2020/3/3 22:35
     */
    Department findByName(String name);

    /**
     * @description 根据部门名查询出该部门的所有的员工
     * @author admin
     * @updateTime 2020/3/3 22:10
     */
    List<Employee> findEmployeesByDepartmentName(String name);
}
