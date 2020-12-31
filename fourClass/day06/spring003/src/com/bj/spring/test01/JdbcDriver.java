package com.bj.spring.test01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDriver {
    @Value("${jdbc.driverClss}")
    private  String name;
    @Value("${jdbc.users}")
    private  String users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "JdbcDriver{" +
                "name='" + name + '\'' +
                ", users='" + users + '\'' +
                '}';
    }
}
