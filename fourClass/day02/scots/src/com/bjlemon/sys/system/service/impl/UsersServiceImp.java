package com.bjlemon.sys.system.service.impl;

import com.bjlemon.pojo.Users;
import com.bjlemon.sys.system.dao.IUsersDao;
import com.bjlemon.sys.system.dao.imp.UsersDaoImp;
import com.bjlemon.sys.system.service.IUsersService;
import com.bjlemon.utiles.ThisAssertion;
import com.bjlemon.utiles.ThisCode;

import   static com.bjlemon.utiles.ThisAssertion.*;

public class UsersServiceImp implements IUsersService {

    IUsersDao iUsersDao =new UsersDaoImp();

    /**
     * 登陆的的用户  张三
     * @param tUsers
     * @return
     * @throws Exception
     */
    @Override
    public Users login(Users tUsers) throws Exception {


        //写上对应的逻辑信息,进行验收用户的账号和密码是否为null


     /*
       由于这种特别的繁琐，创建多个方法就需要多个语句吧，
       为开发方便，那么我们找这里使用断言

        if(tUsers.getUsersAccout()!=null){
            //写上对应逻辑数据
        }*/
        isNotNull("用户名称不能为空",tUsers.getUsersAccout());
        isNotNull("用户密码不能为空",tUsers.getUsersPwd());

        //调用dao层
        tUsers.setUsersMrak(ThisCode.OBJ_CODE);
                Users users = iUsersDao.loginDao(tUsers);
                users.setUsersPwd(null);
        return  users;
    }

    /**
     * 修改信息  张三
     * @param tUsers
     * @throws Exception
     */
    @Override
    public void updateUsersMessage(Users tUsers) throws Exception {
        //断言修改的用户编号  id
        isNotNumberNull("用户编号不存在",tUsers.getUsersId());
        //如其它的  用户  密码  这些不在这里进行断言，同学可执行的断言

        //进行调用Dao层数据
        int  i=   iUsersDao.updateUsersMessageDao(tUsers);
        isNotNumberNull("用户信息修改失败",i);

    }

    /**
     *
     */
   /* public   void test(){
        if(tUsers.getUsersAccout()!=null){
            //写上对应逻辑数据
        }

    }*/
}
