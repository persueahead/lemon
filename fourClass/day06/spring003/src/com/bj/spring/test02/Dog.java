package com.bj.spring.test02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
/*@Component*/
public class Dog {/*
       @Value("小黄")*/
    private  String name;
    /*  @Value("白色")*/
     private  String color;

    public Dog() {
        System.out.println("    public Dog()");
    }

    /**
       *
       */
      @PostConstruct //类似 init-method=""
      public   void testInit(){
          System.out.println("public   void testInit()");
      }

      /**
       *
       */
      @PreDestroy //类似于destroy-method=""
      public   void testDestroy(){
          System.out.println("public   void testDestroy");
      }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
