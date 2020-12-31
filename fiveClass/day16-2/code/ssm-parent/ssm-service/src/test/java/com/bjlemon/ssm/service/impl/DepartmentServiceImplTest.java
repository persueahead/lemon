package com.bjlemon.ssm.service.impl;

import com.bjlemon.ssm.domain.Department;
import com.bjlemon.ssm.service.DepartmentService;
import com.bjlemon.ssm.vo.DepartmentQueryVO;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentServiceImplTest.java
 * @Description TODO
 * @createTime 2020年03月07日 22:56:00
 */
@ContextConfiguration(value = "classpath*:spring/applicationContext-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    /*@Test
    public void addDepartment() {
        Department department = new Department();
        department.setDepartmentName("IBM");
        department.setDepartmentLocation("LOS");
        this.departmentService.addDepartment(department);
    }

    @Test
    public void testDeleteDepartment() {
        Department department = this.departmentService.findDepartmentById(3);
        this.departmentService.deleteDepartment(department);
    }

    @Test
    public void testModifyDepartment() {
        Department department = this.departmentService.findDepartmentById(2);
        department.setDepartmentName("Apple");
        department.setDepartmentLocation("New York");
        this.departmentService.modifyDepartment(department);
    }

    @Test
    public void testFindAll() {
        this.departmentService.findAllDepartmentList().stream().forEach(System.out::println);
    }

    @Test
    public void testFindByQueryVO() {
        DepartmentQueryVO departmentQueryVO = new DepartmentQueryVO();
        departmentQueryVO.setDepartmentName("B");
        departmentQueryVO.setDepartmentLocation("B");

        this.departmentService.findDepartmentListByQueryVO(departmentQueryVO).stream().forEach(System.out::println);
    }

    */

    @Test
    public void testFindPaginationByQueryVO() {
        DepartmentQueryVO departmentQueryVO = new DepartmentQueryVO();
        departmentQueryVO.setDepartmentName("B");

        PageInfo<Department> pageInfo = this.departmentService.findDepartemntPaginationListByQueryVO(2, 3, departmentQueryVO);
        System.out.println(pageInfo);
    }


}