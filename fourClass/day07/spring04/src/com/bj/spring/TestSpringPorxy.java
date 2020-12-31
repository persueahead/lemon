package com.bj.spring;

import com.bj.serivce.IStudentSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appliactionContext.xml")
public class TestSpringPorxy {

    @Resource(name = "usersServiceImp")
    private  IUsersService  iusersservice;

    /**
     *
     */
    @Test
    public   void test() throws Exception {

        iusersservice.del();
       // iStudentSerivce.save();
    }

}
