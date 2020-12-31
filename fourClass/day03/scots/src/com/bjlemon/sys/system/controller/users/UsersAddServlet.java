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

@WebServlet("/system/usersAddServlet")
public class UsersAddServlet extends HttpServlet {
    IUsersService  iUsersService=new UsersServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //获取用户的数据信息

              try {
                  Users tUsers = RequestBeanUtils.requestToBean(request, Users.class);

                  //进行调用Serivce数据 -转调用dao层-转调用util util中添加方法执行失败会跳出异常
                  iUsersService.addUsersService(tUsers);

                  //如果数据添加成功
                    //返回添加页面（添加页面-servlet-添加页面） 处理快视觉上感觉页面没变化
                    //并且提示用户添加的数据
                  request.setAttribute("tip","用户信息添加成功");

                  request.getRequestDispatcher("/view/system/user/userinfo_add.jsp").forward(request,response);
              }catch (Exception  e){
                    e.printStackTrace();
                  request.setAttribute("tip",e.getMessage());
                  request.getRequestDispatcher("/view/system/user/userinfo_add.jsp").forward(request,response);

              }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //进行跳转到用户添加的页面
        request.getRequestDispatcher("/view/system/user/userinfo_add.jsp").forward(request,response);

    }

}
