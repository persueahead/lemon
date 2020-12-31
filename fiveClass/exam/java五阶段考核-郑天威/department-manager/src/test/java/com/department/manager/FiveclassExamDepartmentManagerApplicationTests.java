package com.department.manager;

import com.department.manager.domain.User;
import com.department.manager.domain.UserExample;
import com.department.manager.mapper.ManagerMapper;
import com.department.manager.mapper.UserMapper;
import com.department.manager.service.UserService;
import com.department.manager.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FiveclassExamDepartmentManagerApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ManagerMapper managerMapper;


    @Test
    void contextLoads() {
        System.out.println(this.userMapper.selectByExample(new UserExample()));
    }
    @Test
    public void testManager(){
        System.out.println(this.managerMapper.selectRoleByManagerId(1));
    }
    @Test
    public void testMappingManual(){
        System.out.println(this.userMapper.selectDepByUserId(1));
    }
    @Test
    public void  testSelectLike(){
        UserService userService=new UserServiceImpl();
        User user=new User();
        user.setDepId(1);
        System.out.println(userService.selectUserWithLike(user));
    }
}
