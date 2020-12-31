package com.bj.spring.test02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Stu {
    @Value("小姐姐")
     private  String name;
    @Resource(name="car01")
    private  Car car;

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
