package com.bj.spring.test04;

import org.springframework.beans.factory.annotation.Value;

public class Car2 {
        @Value("玛莎拉蒂")
        private  String name;
        @Value("蓝色")
        private  String color;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Car2() {
        System.out.println("car实例化");
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
