package com.bj.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    @Test
     public void a(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
// Users useer = (Users) apth.getBean("users");
    }



}
