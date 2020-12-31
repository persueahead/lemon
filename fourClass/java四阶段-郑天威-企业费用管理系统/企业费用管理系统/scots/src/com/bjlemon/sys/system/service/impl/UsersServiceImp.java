package com.bjlemon.sys.system.service.impl;

import com.bjlemon.pojo.Menu;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;
import com.bjlemon.sys.system.dao.IUsersDao;
import com.bjlemon.sys.system.dao.imp.UsersDaoImp;
import com.bjlemon.sys.system.service.IUsersService;
import com.bjlemon.utiles.ThisAssertion;
import com.bjlemon.utiles.ThisCode;

import java.util.List;

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
//     断言判断 是否为空
        isNotNull("用户名称不能为空",tUsers.getUsersAccount());
        isNotNull("用户密码不能为空",tUsers.getUsersPwd());
       // tUsers.setUsersPwd(ThisPassWordSHA.getFormatSHA(users.getUsersPwd()));
        //调用dao层
             //设置状态码
        tUsers.setUsersMark(ThisCode.OBJ_CODE);
        System.out.println("设置状态码后:"+tUsers);
//                调用dao层方法查询完整信息
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

    @Override
    public List<Menu> selectMenu(Integer roleId) throws Exception {


        return iUsersDao.selectMenuDao(roleId);
    }

    /**
     * 添加
     * @param tUsers
     * @throws Exception
     */
    @Override
    public void addUsersService(Users tUsers) throws Exception {

        //进行断言  账号密码不为空 null
        isNotNull("用户名称不能为空",tUsers.getUsersAccount());
        isNotNull("用户密码不能为空",tUsers.getUsersPwd());

        //其他的数据同学们可以下来可以进行执行断言

      int  i=  iUsersDao.addUsersDao(tUsers);

      //进行判断是否添加成功
        isNotNumberNull("用户信息添加失败",i);

    }

    /**
     * 查询
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public List<Users> selectListUsers(Users o) throws Exception {

        List<Users>  list= iUsersDao.selectListUsers(o);
        return list;
    }

    /**
     * 删除员工信息
     * @param users
     * @throws Exception
     */
    @Override
    public void delUsersService(Users users) throws Exception {
   //进行断言ids 删除用户的编号是有
        int  i=iUsersDao.delUsersDao(users);
        //进行判断是否用户删除失败
        isNotNumberNull("用户删除失败",i);
    }

    /**
     * 修改user数据
     * @param users
     * @throws Exception
     */
    @Override
    public void updateUsersService(Users users) throws Exception {
        //一样可以断言，断言的方式和之前是一样的
       int i= iUsersDao.updateUsersDao(users);
        //进行判断是否用户删除失败
        isNotNumberNull("用户删修改失败",i);
    }

    @Override
    public List<Salary> selectImgs(Integer usersId) throws Exception {

        return   iUsersDao.selectSalaryIMG(usersId);
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
