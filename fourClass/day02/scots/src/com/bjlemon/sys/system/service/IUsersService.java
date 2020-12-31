package com.bjlemon.sys.system.service;

import com.bjlemon.pojo.Users;

public interface IUsersService {
    //登陆
    Users login(Users tUsers)throws  Exception;
    //修改
    void updateUsersMessage(Users tUsers)throws Exception;
}
