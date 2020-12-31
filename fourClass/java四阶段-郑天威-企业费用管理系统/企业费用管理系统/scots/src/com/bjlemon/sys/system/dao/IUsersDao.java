package com.bjlemon.sys.system.dao;

import com.bjlemon.pojo.Menu;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;

import java.util.List;

public interface IUsersDao {
    //用户登录
    Users loginDao(Users tUsers)throws  Exception;

    //修改用户的信息
    int updateUsersMessageDao(Users tUsers)throws  Exception;
   //查询菜单的权限
    List<Menu> selectMenuDao(Integer roleId)throws  Exception;
    //添加用户信息
    int addUsersDao(Users tUsers)throws  Exception;
    //用户的查询
    List<Users> selectListUsers(Users o)throws  Exception;
    //用户的删除
    int delUsersDao(Users users)throws Exception;
       //修改用户
    int updateUsersDao(Users users)throws  Exception;

    List<Salary> selectSalaryIMG(Integer usersId) throws Exception ;
}
