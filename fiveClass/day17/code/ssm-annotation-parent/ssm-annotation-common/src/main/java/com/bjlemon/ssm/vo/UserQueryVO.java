package com.bjlemon.ssm.vo;

import java.io.Serializable;
import java.util.Date;

public class UserQueryVO implements Serializable {

    private String userName;

    private String userPassword;

    private Float userSalary;

    private Date userBirthday;

    private Integer departmentId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
}
