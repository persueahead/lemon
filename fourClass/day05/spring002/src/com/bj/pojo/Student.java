package com.bj.pojo;

public class Student {
    /**
     *
     */
    private  Integer id;
    /**
     *
     */
    private  String name;


    public  void  getInit(){
        System.out.println("-----我是一个初始化的方法-----");
    }

    public  void  getDestroy(){
        System.out.println("======我是一个销毁的方法=============");
    }

    @Override
    public String toString() {
        return "Student{" +
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
