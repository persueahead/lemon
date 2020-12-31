package com.bj.spring.test;

import com.bj.spring.pojo.Users;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

    //使用Junit
      /**
       *
       */
      @org.junit.Test
      public   void test(){
          //1.创建容器对象的
          ClassPathXmlApplicationContext context =
                  new ClassPathXmlApplicationContext("applicationContext.xml");
                //从容器中获取对象
          Users users = (Users) context.getBean("users");

          System.out.println(users);


      }

}
