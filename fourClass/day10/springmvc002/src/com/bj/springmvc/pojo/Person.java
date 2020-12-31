package com.bj.springmvc.pojo;

public class Person {

    /**
     *
     */
    private  String phone;

    /**
     *
     */
    private  String Classs;

    @Override
    public String toString() {
        return "Person{" +
                "phone='" + phone + '\'' +
                ", Classs='" + Classs + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClasss() {
        return Classs;
    }

    public void setClasss(String classs) {
        Classs = classs;
    }
}
