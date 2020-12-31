package com.bjlemon.sys.system.controller.users;

import com.bjlemon.pojo.Users;
import com.bjlemon.sys.system.service.IUsersService;
import com.bjlemon.sys.system.service.impl.UsersServiceImp;
import com.my.web.servlet.RequestBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/system/usersListQueryServlet")
public class UsersListQueryServlet extends HttpServlet {

    IUsersService  iUsersService=new UsersServiceImp();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            try {
                //获取查询的数据 封装成bean对象 此bean属性已经赋值  是具体查询
                Users users = RequestBeanUtils.requestToBean(request, Users.class);
                //传入bean参数
                List<Users> usersList=iUsersService.selectListUsers(users);
                request.setAttribute("users",users);
                request.setAttribute("usersList",usersList);
                request.getRequestDispatcher("/view/system/user/userinfo_list.jsp").forward(request,response);
            }catch (Exception  e){

                  e.printStackTrace();
              }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      用户管理菜单栏直接跳转，为get方式
        try {

//        new Users()  属性全为空 则就是
//                      SELECT u.*,r.roleName  FROM t_users  u  INNER JOIN  t_role  r ON  u.roleId=r.roleId    AND  u.usersMark=?
//                          只要 u.roleId=r.roleId  这样查出来的是所有 并没有限制具体条件              usersMark 默认传入的0（能用的员工）
//        接收所有查询到的usersbean
         List<Users> usersList=iUsersService.selectListUsers(new Users());
//                设置属性背页面接收 直接显示
            request.setAttribute("usersList",usersList);
            request.getRequestDispatcher("/view/system/user/userinfo_list.jsp").forward(request,response);
          }catch (Exception  e){

              e.printStackTrace();
          }





    }
}
