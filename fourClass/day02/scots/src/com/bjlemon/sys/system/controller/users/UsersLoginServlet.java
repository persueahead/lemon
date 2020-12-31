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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/system/usersLoginServlet")
public class UsersLoginServlet extends HttpServlet {


    IUsersService iUsersService=new UsersServiceImp();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");*/
         //获取对应的数据   ?
        //格式化字符集?
     /*
        由于这种方式特别的麻烦，我们可以使用实体类来获取
          30条  要写30个种的数据
        String userAccount = request.getParameter("userAccount");
        */
      //通过实体类来获取对应的数据
        //注意使用这方法 获取数据，那么页面的name值要和实体列的属性名称相同，

        try {
      Users tUsers = RequestBeanUtils.requestToBean(request, Users.class);
        System.out.println("========");
        System.out.println(tUsers);


        //调用Service层数据
            Users  users= iUsersService.login(tUsers);
            System.out.println("查询的数据：："+users);
            if(users!=null){
                //将数据存入到session中 ,并进行跳转到首页(index.jsp)
               HttpSession session = request.getSession();
               session.setAttribute("users",users);
                //重定向或者转发
               response.sendRedirect("/view/index.jsp");
           }else{

               //如果查询不不到数据，出错，就进行跳转到登陆的页面
               //并且提示错误
               request.setAttribute("tip","用户名或者密码错误");
               request.getRequestDispatcher("/view/login.jsp").forward(request,response);
           }






            }catch (Exception  e){
                e.printStackTrace();
            request.setAttribute("tip","用户名或者密码错误");
            request.getRequestDispatcher("/view/login.jsp").forward(request,response);
            }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


}
