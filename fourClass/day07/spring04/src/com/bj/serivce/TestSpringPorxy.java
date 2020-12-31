package com.bj.serivce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appliactionContext.xml")
public class TestSpringPorxy {

    @Resource(name = "studentSerivceImp")
    private  IStudentSerivce  iStudentSerivce;

    /**
     *
     */
    @Test
    public   void test() throws Exception {

        iStudentSerivce.del();
       // iStudentSerivce.save();
    }

}
