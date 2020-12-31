package com.bj.jdbc.pojo;

public class Users {
    /**
     *
     */
    private  Integer userId;
    private  Integer userMoney;
    /**
     *money*/
    private  String userName;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userMoney=" + userMoney +
                ", userName='" + userName + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Integer userMoney) {
        this.userMoney = userMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
