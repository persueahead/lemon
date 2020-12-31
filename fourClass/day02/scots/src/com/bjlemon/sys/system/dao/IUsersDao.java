package com.bjlemon.sys.system.dao;

import com.bjlemon.pojo.Users;

public interface IUsersDao {
    //用户登录
    Users loginDao(Users tUsers)throws  Exception;

    //修改用户的信息
    int updateUsersMessageDao(Users tUsers)throws  Exception;
}
