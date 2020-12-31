package com.bjlemon.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
//        User user = new User(1,"zhangsan","admin",12.34F,new Date());
//        this.userService.addUser(user);
    }

    @Test
    public void deleteUser() {
        this.userService.deleteUser(this.userService.findUserById(1));
    }

    @Test
    public void modifyUser() {
    }

    @Test
    public void findUserById() {
        System.out.println(this.userService.findUserById(1));
    }

    @Test
    public void findAllUserList() {
        this.userService.findAllUserList().stream().forEach(System.out::println);
    }

    @Test
    public void testFindUsersByDepartmentName() {
        List<User> userList = this.userService.findUserListByDepartmentName("IBM");
        userList.stream().forEach(System.out::println);
    }

    @Test
    public void testFindUsersByDepartmentName1() {
        List<User> userList = this.userService.findUserListByDepartmentName1("IBM");
        for (User user : userList) {
            System.out.println(user);
            System.out.println("--------------------");
            System.out.println(user.getDepartment());

            System.out.println();
        }
    }

    @Test
    public void testFindPaginationList() {
        IPage<User> page = this.userService.findUserPaginationList(2, 3);
        List<User> userList = page.getRecords();
        
    }
}