package com.bjlemon.jpa.service.impl;

import com.bjlemon.jpa.service.DepartmentService;
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
 * @createTime 2020年01月16日 22:38:00
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void testFindDepartmentByUserName() {
        System.out.println(this.departmentService.findDepartmentByUserName("zhangsan"));
    }
}