package com.bj.spring.test01;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Controller
public class Student {

    /**
     *
     */
    private  String name;

    /**
     *
     */
    private  String phone;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
