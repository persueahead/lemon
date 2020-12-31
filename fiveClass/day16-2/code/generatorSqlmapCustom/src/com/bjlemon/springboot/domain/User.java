package com.bjlemon.springboot.domain;

import java.util.Date;

public class User {
    private Integer userId;

    private Date userBirthday;

    private String userName;

    private String userPassword;

    private Float userSalary;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Float getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(Float userSalary) {
        this.userSalary = userSalary;
    }
}