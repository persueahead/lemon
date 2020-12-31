package com.bjlemon.pojo;

public class Users  {
    /**
     *用户的编号
     */
    private  Integer usersId;
    /**
     *角色编号
     */
    private  Integer roleId;
    /**
     *用户名称
     */
    private  String usersName;
    /**
     *用户的年龄
     */
    private  Integer usersAge;

    /**
     *用户的手机号
     */
    private  String usersPhone;


    /**
     *用户的薪资
     */
    private   Float usersSalary;

    /**
     *用户的账号
     */
    private  String usersAccout;


    /**
     *用户的密码
     */
    private  String usersPwd;
    /**
     *用户的标识
     */
    private  String usersMrak;
    //性别
    private  String usersSex;

    /**
     *角色的名称
     */
    private  String roleName;

    @Override
    public String toString() {
        return "Users{" +
                "usersId=" + usersId +
                ", roleId=" + roleId +
                ", usersName='" + usersName + '\'' +
                ", usersAge=" + usersAge +
                ", usersPhone='" + usersPhone + '\'' +
                ", usersSalary=" + usersSalary +
                ", usersAccout='" + usersAccout + '\'' +
                ", usersPwd='" + usersPwd + '\'' +
                ", usersMrak='" + usersMrak + '\'' +
                ", usersSex='" + usersSex + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public String getUsersSex() {
        return usersSex;
    }

    public void setUsersSex(String usersSex) {
        this.usersSex = usersSex;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public Integer getUsersAge() {
        return usersAge;
    }

    public void setUsersAge(Integer usersAge) {
        this.usersAge = usersAge;
    }

    public String getUsersPhone() {
        return usersPhone;
    }

    public void setUsersPhone(String usersPhone) {
        this.usersPhone = usersPhone;
    }

    public Float getUsersSalary() {
        return usersSalary;
    }

    public void setUsersSalary(Float usersSalary) {
        this.usersSalary = usersSalary;
    }

    public String getUsersAccout() {
        return usersAccout;
    }

    public void setUsersAccout(String usersAccout) {
        this.usersAccout = usersAccout;
    }

    public String getUsersPwd() {
        return usersPwd;
    }

    public void setUsersPwd(String usersPwd) {
        this.usersPwd = usersPwd;
    }

    public String getUsersMrak() {
        return usersMrak;
    }

    public void setUsersMrak(String usersMrak) {
        this.usersMrak = usersMrak;
    }
}
