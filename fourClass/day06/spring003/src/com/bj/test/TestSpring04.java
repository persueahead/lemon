package com.bj.test;

import com.bj.spring.test05.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//创建容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appliactionContext.xml")//加载配置文件
public class TestSpring04 {

    @Resource(name="users")
    private Users users;

    @Test
    public   void test(){
        users.testUsers();
    }
}
