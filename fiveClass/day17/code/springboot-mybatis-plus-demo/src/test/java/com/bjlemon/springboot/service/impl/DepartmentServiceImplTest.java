package com.bjlemon.springboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.service.DepartmentService;
import com.bjlemon.springboot.vo.DepartmentQueryVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentServiceImplTest.java
 * @Description TODO
 * @createTime 2020年01月12日 22:14:00
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void addDepartment() {
        Department department = new Department();
        department.setName("Oracle");
        department.setLocation("NEWYORK");
        this.departmentService.addDepartment(department);
    }

    @Test
    public void deleteDepartment() {
        Department department = this.departmentService.findDepartmentById(1);
        this.departmentService.deleteDepartment(department);
    }

    @Test
    public void modifyDepartment() {
        Department department = this.departmentService.findDepartmentById(22);
        department.setName("JBoss");
        this.departmentService.modifyDepartment(department);
    }

    @Test
    public void findDepartmentById() {
    }

    @Test
    public void findAllDepartmentList() {
        this.departmentService.findAllDepartmentList().stream().forEach(System.out::println);
    }

    @Test
    public void findDepartmentListByQueryVO() {
        DepartmentQueryVO departmentQueryVO = new DepartmentQueryVO();
        departmentQueryVO.setName("e");
        List<Department> departmentList = this.departmentService.findDepartmentListByQueryVO(departmentQueryVO);
        departmentList.stream().forEach(System.out::println);
    }

    @Test
    public void findDepartmentPaginationList() {
        Page<Department> page = this.departmentService.findDepartmentPaginationList(2, 3);
        System.out.println(page);
    }
}