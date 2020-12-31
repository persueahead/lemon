package com.bj.pojo;

public class UsersFactory {
    public  static  Users  createUsers
            (){
        System.out.println("我是静态的工厂方法");
        return  new Users();
    }

    public    Users  createUsers02
            (){
        System.out.println("我是静态的工厂方法");
        return  new Users();
    }
}
