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
    private  String usersAccount;


    /**
     *用户的密码
     */
    private  String usersPwd;
    /**
     *用户的标识
     */
    private  String usersMark;
    //性别
    private  String usersSex;

    /**
     *角色的名称
     */
    private  String roleName;
    //手动拼接多选案例的
    private  String ck;

    /**
     *
     */
    private  Integer[]  ids ;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public String getCk() {
        ck="<INPUT TYPE='checkbox' value='"+getUsersId()+"' name='ids' />";
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public Users() {
        super();
    }

    public Users(Integer usersId) {
        super();
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersId=" + usersId +
                ", roleId=" + roleId +
                ", usersName='" + usersName + '\'' +
                ", usersAge=" + usersAge +
                ", usersPhone='" + usersPhone + '\'' +
                ", usersSalary=" + usersSalary +
                ", *usersAccount='" + usersAccount + '\'' +
                ", usersPwd='" + usersPwd + '\'' +
                ", usersMark='" + usersMark + '\'' +
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

    public String getUsersAccount() {
        return usersAccount;
    }

    public void setUsersAccount(String usersAccount) {
        this.usersAccount = usersAccount;
    }

    public String getUsersPwd() {
        return usersPwd;
    }

    public void setUsersPwd(String usersPwd) {
        this.usersPwd = usersPwd;
    }

    public String getUsersMark() {
        return usersMark;
    }

    public void setUsersMark(String usersMark) {
        this.usersMark = usersMark;
    }
}
