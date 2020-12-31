package com.bjlemon.springboot.service.impl;

import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void testFindDepartmentByName() {
        Department department = this.departmentService.findDepartmentByName("IBM");
        System.out.println(department);
    }

    @Test
    public void testFindDepartmentByName1() {
        Department department = this.departmentService.findDepartmentByName1("IBM");
        System.out.println(department);
    }
}