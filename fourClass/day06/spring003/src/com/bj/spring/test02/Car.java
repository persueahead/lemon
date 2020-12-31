package com.bj.spring.test02;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car01")
public class Car implements InitializingBean,DisposableBean {
    @Value("法拉利")
    private  String name;
    @Value("红色")
    private  String color;

    @Override
    public void destroy() throws Exception {
        System.out.println(" public void destroy() throws Exception");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("  public void afterPropertiesSet() throws Exception");
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
