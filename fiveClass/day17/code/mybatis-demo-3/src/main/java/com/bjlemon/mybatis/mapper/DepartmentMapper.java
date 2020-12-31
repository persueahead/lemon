package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Department;
import com.bjlemon.mybatis.domain.Employee;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentMapper.java
 * @Description TODO
 * @createTime 2019年12月26日 21:16:00
 */
public interface DepartmentMapper {

    /**
     * @description 根据部门名称查询该部门下的所有员工
     * @author admin
     * @updateTime 2019/12/26 22:13
     */
    List<Employee> findEmployeesByDepartmentName(String name);

    /**
     * @description 根据部门名称查询部门，同时将部门的用户查询出来
     * @author admin
     * @updateTime 2019/12/26 22:22
     */
    Department findByName(String name);

    void save(Department department);

    Department findById(Integer id);

}
