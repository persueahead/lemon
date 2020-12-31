package com.bjlemon.springboot.domain;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Float userSalary;

    private Date userBirthday;

    private Integer departmentId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSalary=" + userSalary +
                ", userBirthday=" + userBirthday +
                ", departmentId=" + departmentId +
                '}';
    }
}