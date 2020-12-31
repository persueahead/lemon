package com.bjlemon.sys.system.service;

import com.bjlemon.pojo.Menu;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;

import java.util.List;

public interface IUsersService {
    //登陆
    Users login(Users tUsers)throws  Exception;
    //修改
    void updateUsersMessage(Users tUsers)throws Exception;
    //查询用户的权限
    List<Menu> selectMenu(Integer roleId)throws Exception;
    //添加用户
    void addUsersService(Users tUsers)throws Exception;
     //用户的查询所有的数据
    List<Users> selectListUsers(Users o)throws  Exception;
    //删除用户
    void delUsersService(Users users)throws  Exception;

    //修改用户的信息
    void updateUsersService(Users users)throws  Exception;

    List<Salary> selectImgs(Integer usersId) throws Exception;
}
