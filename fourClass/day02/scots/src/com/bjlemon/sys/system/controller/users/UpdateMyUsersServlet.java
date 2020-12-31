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

@WebServlet("/system/updateMyUsersServlet")
public class UpdateMyUsersServlet extends HttpServlet {


    IUsersService iUsersService=new UsersServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {


         //获取数据
         Users tUsers = RequestBeanUtils.requestToBean(request, Users.class);

         System.out.println("========");
         System.out.println(tUsers);
         //调用dao层
         iUsersService.updateUsersMessage(tUsers);
         request.setAttribute("tip","当前用户的信息修改成功");

         request.getSession().setAttribute("users",tUsers);
         request.getRequestDispatcher("/view/system/user/userinfo_show.jsp").forward(request,response);

       }catch (Exception  e){
         request.setAttribute("tip",e.getMessage());
         request.getRequestDispatcher("/view/system/user/userinfo_show.jsp").forward(request,response);
           e.printStackTrace();
       }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
