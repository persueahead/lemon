package com.bj.pojo;

public class Users {

    /**
     *
     */
    private  Integer id;
    /**
     *
     */
    private  String name;


    public Users() {
        System.out.println("我是空参数的构造函数");


    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}