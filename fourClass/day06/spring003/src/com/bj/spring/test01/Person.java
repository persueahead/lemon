package com.bj.spring.test01;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class Person {
    private  String name;
    private  String phone;
    @Value("1008611")
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Value("隔壁小姐姐")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
