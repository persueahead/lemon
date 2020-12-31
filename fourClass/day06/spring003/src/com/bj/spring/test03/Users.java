package com.bj.spring.test03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class Users {
//    容器对象
    ApplicationContext ac;

    public Users() {
        System.out.println("创建了对象");

    }

    public Car testSerivce() {
        Car c = testCar();
        System.out.println("============" + c.getClass() );
        return c;
    }

    public Car testCar() {
//        通过容器获取bean对象
        return ac.getBean(Car.class);
    }

    public ApplicationContext getAc() {
        return ac;
    }

    public void setAc(ApplicationContext ac) {
        this.ac = ac;
    }

    @Override
    public String toString() {
        return "Users{" +
                "ac=" + ac +
                '}';
    }
}
