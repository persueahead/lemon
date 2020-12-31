package com.bj.spring.test03;

public class Car {
    /**
     *
     */
    private  String name;
    private String color;

    public Car() {
        System.out.println("创建了car对象");
    }

    @Override
    public String toString() {
        return "Car{" +
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
