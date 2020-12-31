package com.bjlemon.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.vo.DepartmentQueryVO;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentService.java
 * @Description TODO
 * @createTime 2020年01月12日 21:44:00
 */
public interface DepartmentService {

    void addDepartment(Department department);

    void deleteDepartment(Department department);

    void modifyDepartment(Department department);

    Department findDepartmentById(Integer id);

    List<Department> findAllDepartmentList();

    List<Department> findDepartmentListByQueryVO(DepartmentQueryVO departmentQueryVO);

    Page<Department> findDepartmentPaginationList(Integer pageNum, Integer pageSize);


}
