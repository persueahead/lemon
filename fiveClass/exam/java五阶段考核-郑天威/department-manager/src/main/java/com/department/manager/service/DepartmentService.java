package com.department.manager.service;

import com.department.manager.domain.Department;
import org.springframework.ui.Model;

import java.util.List;

public interface DepartmentService {
    /**
     * 添加部门
     * @return
     */
    int addDepartment(Department department);

    /**
     * 查询所有部门
     * @return
     */
    List<Department> allDepartmentList();

    /**
     * 按id修改部门
     * @param department
     * @return
     */
    int modifyDepartment(Department department);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteDepartmentById(int[] ids);

    /**
     * 按名称查部门
     * @param depName
     * @return
     */
    Department selectByDepartmentName(String depName);

    /**
     * 通过id查找部门
     * @param depId
     * @return
     */
    Department selectByDepartmentId(int depId);

    /**
     * 刷新baseDepartment
     * @param baseDepartment
     * @param model
     */
    void rebuildBaseDepartment(List<Department> baseDepartment, Model model);
}
