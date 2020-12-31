package com.bjlemon.ssm.service;

import com.bjlemon.ssm.domain.Department;
import com.bjlemon.ssm.vo.DepartmentQueryVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentService.java
 * @Description TODO
 * @createTime 2019年12月31日 22:18:00
 */
public interface DepartmentService {

    PageInfo<Department> findPaginationList(Integer pageNum, Integer pageSize);

    /**
     * @description 有条件分页
     * @author admin
     * @updateTime 2020/1/2 20:20
     */
    PageInfo<Department> findPaginationList(Integer pageNum, Integer pageSize, DepartmentQueryVO departmentQueryVO);

    void addDepartment(Department department);

    List<Department> findAll();

}
