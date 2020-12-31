package com.bj.test;

import com.bj.spring.test01.JdbcDriver;
import com.bj.spring.test01.JdbcTest;
import com.bj.spring.test02.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring02 {
    @Test
    public   void test04(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Stu01 stu02 = (Stu01) apth.getBean("stu02");
        System.out.println(stu02);
    }
    @Test
    public   void test03(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Car dog = (Car) apth.getBean("car01");
        System.out.println(dog);
    }
    @Test
    public   void test02(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Dog dog = (Dog) apth.getBean("dog");
        System.out.println(dog);
    }
    @Test
    public   void test01(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Stu stu = (Stu) apth.getBean("stu");
        System.out.println(stu);
    }

    @Test
    public   void test(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Person person = (Person) apth.getBean("person01");
        System.out.println(person);
    }
}
