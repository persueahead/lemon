package com.department.manager.domain;

import java.io.Serializable;

/**
 * @discription 员工
 */
public class User implements Serializable {

    private static final long serialVersionUID = -6578381977877374819L;
    private Integer userId;

    private Integer depId;

    private String userName;

    private String userSex;

    private Integer userState;
    private String depName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDepId() {
        return depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", depId=" + depId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userState=" + userState +
                ", depName='" + depName + '\'' +
                '}';
    }
}