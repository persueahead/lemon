package com.bj.spring.tst;

import com.bj.spring.serivce.UsersSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpring {

    @Resource(name = "usersSerivce")
    private UsersSerivce  usersSerivce;

/**
 *
 */
        @Test
        public   void test(){
            usersSerivce.getTestSpring(1,2,200);
        }
}
