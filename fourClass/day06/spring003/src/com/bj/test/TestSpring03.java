package com.bj.test;

import com.bj.spring.test02.*;
import com.bj.spring.test03.*;
import com.bj.spring.test03.Car;
import com.bj.spring.test04.Student;
//import com.bj.spring.test05.Users;
import com.bj.spring.test03.Users;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring03 {

    @Test
    public   void test02(){
        ClassPathXmlApplicationContext apth
//                加载配置时已经创建了users对象
                = new ClassPathXmlApplicationContext("appliactionContext02.xml");
//        Users users = (Users) apth.getBean("users");
//        调用时才创建car，地址不同
//       Car car1= users.testSerivce();
//       Car car2=users.testSerivce();
//        System.out.println(car1==car2);
    }

    @Test
    public   void test01(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext03.xml");
        Student student = (Student) apth.getBean("student");
        System.out.println(student.getCar()==student.getCar());
    }

    @Test
    public   void test(){
        ClassPathXmlApplicationContext apth
                = new ClassPathXmlApplicationContext("appliactionContext.xml");
       /* Users person = (Users) apth.getBean("users");
        person.testSerivce();*/
    }
}
