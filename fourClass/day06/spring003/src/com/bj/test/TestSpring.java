package com.bj.test;

import com.bj.spring.test01.Car;
import com.bj.spring.test01.Person;
import com.bj.spring.test01.Student;
import com.bj.spring.test01.Users;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public   void test06(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Person person = (Person) apth.getBean("person");
        System.out.println(person);
    }


    @Test
    public   void test05(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Car car = (Car) apth.getBean("car");
        System.out.println(car);
    }

    @Test
    public   void test04(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Car car = (Car) apth.getBean("car");
        Car car01 = (Car) apth.getBean("car");
        System.out.println(car==car01);
    }

    @Test
    public   void test03(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Car car = (Car) apth.getBean("car");
        System.out.println(car);
    }
    @Test
    public   void test02(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Student person = (Student) apth.getBean("student");
        System.out.println(person);
    }

    @Test
    public   void test01(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Person person = (Person) apth.getBean("person");
        System.out.println(person);
    }

    /**
     *
     */
    @Test
    public   void test(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
        Users Users = (Users) apth.getBean("users");
        System.out.println(Users);
    }
}
