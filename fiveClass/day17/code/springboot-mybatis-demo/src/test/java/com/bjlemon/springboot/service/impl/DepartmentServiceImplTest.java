package com.bjlemon.springboot.service.impl;

import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.service.DepartmentService;
import com.bjlemon.springboot.vo.DepartmentQueryVO;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentServiceImplTest.java
 * @Description TODO
 * @createTime 2020年01月12日 20:11:00
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void addDepartment() {
        Department department = new Department();
        department.setDepartmentName("SUN");
        department.setDepartmentLocation("LOS");

        this.departmentService.addDepartment(department);
    }

    @Test
    public void testDeleteDepartment() {
        Department department = this.departmentService.findDepartmentById(1);
        this.departmentService.deleteDepartment(department);
    }

    @Test
    public void testModifyDepartment() {
        Department department = this.departmentService.findDepartmentById(2);
        department.setDepartmentName("Apple");
        this.departmentService.modifyDepartment(department);
    }

    @Test
    public void testFindAllDepartmentList() {
        this.departmentService.findAllDepartmentList().stream().forEach(System.out::println);
    }

    @Test
    public void testFindDepartmentsByDepartmentQueryVO() {
        DepartmentQueryVO departmentQueryVO = new DepartmentQueryVO();
        departmentQueryVO.setDepartmentName("e");
        this.departmentService.findDepartmentListByQueryVO(departmentQueryVO).stream().forEach(System.out::println);
    }

    @Test
    public void testFindDepartmentPaginationList() {
        PageInfo<Department> pageInfo = this.departmentService.findDepartmentPaginationList(2, 3);
        System.out.println(pageInfo);
    }

}