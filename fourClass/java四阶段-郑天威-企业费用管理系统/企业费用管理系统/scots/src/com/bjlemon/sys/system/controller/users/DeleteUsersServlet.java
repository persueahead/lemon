package com.bjlemon.sys.system.controller.users;

import com.bjlemon.pojo.Users;
import com.bjlemon.sys.system.service.IUsersService;
import com.bjlemon.sys.system.service.impl.UsersServiceImp;
import com.my.web.servlet.RequestBeanUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/system/deleteUsersServlet")
public class DeleteUsersServlet extends HttpServlet {

    IUsersService  iUsersService= new UsersServiceImp();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           try {
               //获取删除之后的数据信息
               Users users = RequestBeanUtils.requestToBean(request, Users.class);
               iUsersService.delUsersService(users);
               request.setAttribute("tip","用户删除成功");
               request.getRequestDispatcher("/system/usersListQueryServlet").forward(request,response);

           }catch (Exception  e){

                 e.printStackTrace();
               request.setAttribute("tip",e.getMessage());
               request.getRequestDispatcher("/system/usersListQueryServlet").forward(request,response);
             }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
