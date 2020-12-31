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
      /*  接受提交的数据信息，包装成bean对象
                 调用方法对数据库数据进行修改
                             覆盖之前的attribute，名称相同
                                    跳转到显示页，继续由el表达式重新显示新的信息*/

         //获取数据，包装成新的bean对象
         Users tUsers = RequestBeanUtils.requestToBean(request, Users.class);

         System.out.println("========");
         System.out.println(tUsers);
         //service层调用dao层执行update，返回数字表示修改是否成功对数据库进行修改
         iUsersService.updateUsersMessage(tUsers);
         request.setAttribute("tip","当前用户的信息修改成功");
//         直接用新的bean对象进行覆盖，重新设置session域的users属性
         request.getSession().setAttribute("users",tUsers);
//         跳转到显示页，session域属性可传递
         request.getRequestDispatcher("/view/system/user/userinfo_show.jsp").forward(request,response);
//         response.sendRedirect("/view/system/user/userinfo_show.jsp");该跳转request域资源不公开共享


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
