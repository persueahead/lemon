package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Department;
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

    Department findDepartmentByEmployeeName(String name);

    /**
     * @description 根据员工名称查询员工，同时将这个员工的部门信息也查询出来
     * @author admin
     * @updateTime 2019/12/26 21:38
     */
    Employee findByName(String name);

    /**
     * @throws
     * @title
     * @description
     * @author jeffzhou
     * @updateTime 2019/12/26 21:33
     */
    void save(Employee employee);

    List<Employee> findEmployeesByDepartmentId(Integer id);

}
