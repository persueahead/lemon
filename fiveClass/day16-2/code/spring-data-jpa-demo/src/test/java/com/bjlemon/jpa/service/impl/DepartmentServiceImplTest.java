package com.bjlemon.jpa.service.impl;

import com.bjlemon.jpa.domain.Department;
import com.bjlemon.jpa.domain.User;
import com.bjlemon.jpa.service.DepartmentService;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:applicationContext.xml")
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void addDepartment() {
        Department department = new Department();
        department.setName("IBM");
        department.setLocation("LOS");

        this.departmentService.addDepartment(department);
    }

    @Test
    public void deleteDepartment() {
        Department department = this.departmentService.findDepartmentById(2);
//        Hibernate.initialize(department);
        this.departmentService.deleteDepartment(department);
    }

    @Test
    public void modifyDepartment() {
        Department department = this.departmentService.findDepartmentById(2);
        department.setName("Apple");
        department.setLocation("BOSTON");
        this.departmentService.modifyDepartment(department);
    }

    @Test
    public void findAll() {
        List<Department> departmentList = this.departmentService.findAllDepartmentList();
        departmentList.stream().forEach(System.out::println);
    }

    @Test
    public void findAllUserListByDepartmentName() {
        List<User> userList = this.departmentService.findAllUserListByDepartmentName("Apple");
        userList.stream().forEach(System.out::println);
    }


}