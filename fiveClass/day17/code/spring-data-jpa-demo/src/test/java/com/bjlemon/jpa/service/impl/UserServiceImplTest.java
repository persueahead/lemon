package com.bjlemon.jpa.service.impl;

import com.bjlemon.jpa.domain.Department;
import com.bjlemon.jpa.domain.User;
import com.bjlemon.jpa.service.UserService;
import com.bjlemon.jpa.vo.UserQueryVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserServiceImplTest.java
 * @Description TODO
 * @createTime 2020年01月14日 22:53:00
 */
@ContextConfiguration(value = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("123456");
        user.setSalary(12.34F);
        user.setBirthday(new Date());

        this.userService.addUser(user);
    }

    @Test
    public void testDeleteUser() {
        User user = this.userService.findUserById(1);
        this.userService.deleteUser(user);
    }

    @Test
    public void testModifyUser() {
        User user = this.userService.findUserById(2);
        user.setName("C罗");
        user.setPassword("123456");
        user.setSalary(99.00F);
        this.userService.modifyUser(user);
    }

    @Test
    public void testFindAll() {
        this.userService.findAllUserList().stream().forEach(System.out::println);
    }

    @Test
    public void testFindUserPaginationList() {
        int pageNum = 1;
        int pageSize = 3;
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        Page<User> page = this.userService.findUserPaginationList(pageRequest);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        page.getContent().stream().forEach(System.out::println);
        System.out.println(page.getNumber());
        System.out.println(page.getSize());
    }


    @Test
    public void testFindUserPaginationList1() {
        int pageNum = 1;
        int pageSize = 3;
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);

        UserQueryVO userQueryVO = new UserQueryVO();
        userQueryVO.setName("a");
        userQueryVO.setPassword("1");

        Page<User> page = this.userService.findUserPaginationList(pageRequest, userQueryVO);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        page.getContent().stream().forEach(System.out::println);
        System.out.println(page.getNumber());
        System.out.println(page.getSize());
    }

    @Test
    public void testFindByName() {
        this.userService.findUserListByName("%a%").forEach(System.out::println);
    }

    @Test
    public void testFindByNameAndSalary() {
        this.userService.findUserListByNameAndSalary1("%a%", 12.34F).forEach(System.out::println);
    }

    @Test
    public void testFindDepartmentByUserName() {
        Department department = this.userService.findDepartmentByUserName("zhangsan");
        System.out.println(department);
    }

}