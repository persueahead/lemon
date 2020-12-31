package com.bjlemon.springboot;

import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.service.DepartmentService;
import com.bjlemon.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootDataJpaDemoApplicationTests {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private UserService userService;

    @Test
    public void testAdd() {
        Department department = new Department();
        department.setName("IBM");
        department.setLocation("LOS");
        this.departmentService.addDepartment(department);
    }

    @Test
    public void testFindUserListByNameAndSalaryScope() {
        List<User> userList = this.userService.findUserListByNameAndSalaryScope("s", Arrays.asList(20.00F, 40.00F));
        userList.stream().forEach(System.out::println);
    }
}
