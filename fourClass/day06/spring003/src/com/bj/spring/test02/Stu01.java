package com.bj.spring.test02;

public class Stu01 {
    private  String name;
    private  Dog  dog ;

    public Stu01() {
        System.out.println("public Stu01()");
    }

    @Override
    public String toString() {
        return "Stu01{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
