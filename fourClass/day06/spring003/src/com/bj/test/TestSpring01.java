package com.bj.test;

import com.bj.spring.test01.JdbcDriver;
import com.bj.spring.test01.JdbcTest;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring01 {


    @Test
    public   void test01(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        JdbcTest jdbctest = (JdbcTest) apth.getBean("jdbcTest");
        System.out.println(jdbctest);
    }
    @Test
    public   void test(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        JdbcDriver jdbcdriver = (JdbcDriver) apth.getBean("jdbcDriver");
        System.out.println(jdbcdriver);
    }
}
