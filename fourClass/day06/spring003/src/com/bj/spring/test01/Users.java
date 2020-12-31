package com.bj.spring.test01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
  表示：
   我们之前使用的bean配置
   <bean name="users" class=""></bean>
* */
@Component("users")
public class Users {
    
    /**
     *id
     */
    private  Integer id;
    

    /**
     *
     */
    private  String name;

    /**
     *
     */
    private  String sex;

    public Users() {
        System.out.println("2222222222222");
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
