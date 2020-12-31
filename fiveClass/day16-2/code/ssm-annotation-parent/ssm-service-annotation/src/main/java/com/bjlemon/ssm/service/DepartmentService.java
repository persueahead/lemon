package com.bjlemon.ssm.service;

import com.bjlemon.ssm.domain.Department;
import com.bjlemon.ssm.domain.Employee;
import com.bjlemon.ssm.vo.DepartmentQueryVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentService.java
 * @Description TODO
 * @createTime 2020年03月07日 22:53:00
 */
public interface DepartmentService {

    void addDepartment(Department department);

    void deleteDepartment(Department department);

    void modifyDepartment(Department department);

    Department findDepartmentById(Integer id);

    List<Department> findAllDepartmentList();

    List<Department> findDepartmentListByQueryVO(DepartmentQueryVO departmentQueryVO);

    /**
     * @param id
     * @return
     */
    List<Employee> findEmployeeListByDepartmentId(Integer id);

    PageInfo<Department> findDepartemntPaginationList(Integer pageNum, Integer pageSize);

    PageInfo<Department> findDepartemntPaginationListByQueryVO(Integer pageNum, Integer pageSize, DepartmentQueryVO departmentQueryVO);
}
