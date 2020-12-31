package com.bj.controller;

import com.bj.pojo.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public   void testAtuo(){
        ClassPathXmlApplicationContext classPath
                = new ClassPathXmlApplicationContext("appliactionContext.xml");

        Person person = (Person) classPath.getBean("person104");
        System.out.println(person);
        //如果需要执行的方法.进行手动的关闭
        classPath.close();
    }


    @Test
    public   void testNull(){
        ClassPathXmlApplicationContext classPath
                = new ClassPathXmlApplicationContext("appliactionContext.xml");

        Car car = (Car) classPath.getBean("car02");
        System.out.println(car);
        //如果需要执行的方法.进行手动的关闭
        classPath.close();
    }

    @Test
    public   void testColl(){
        ClassPathXmlApplicationContext classPath
                = new ClassPathXmlApplicationContext("appliactionContext.xml");

        Collection collection = (Collection) classPath.getBean("coll05");
        System.out.println(collection);
        //如果需要执行的方法.进行手动的关闭
        classPath.close();
    }

/**
 *
 */
    @Test
    public   void test(){
        ClassPathXmlApplicationContext classPath
                = new ClassPathXmlApplicationContext("appliactionContext.xml");

        Person person = (Person) classPath.getBean("person07");
        System.out.println(person);
        //如果需要执行的方法.进行手动的关闭
        classPath.close();
    }


}



