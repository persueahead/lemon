package com.bjlemon.sys.system.controller.users;

import com.bjlemon.pojo.Menu;
import com.bjlemon.pojo.Salary;
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
import java.util.List;

/*
@webServlet("/***servlet")  /****表示根目录下
本身地址 http://8080  /项目名 /servleturl   该项目有俩/合并

jsp中开头有设置
  //获取绝对路径
    String path = request.getContextPath();

    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
            jsp跳转servlet时有基础地址 <base href="<%=basePath%>"/> 此处已经自带/了 所以jsp跳转servlet不需要额外再加/
            而servlet跳转jsp没有基础地址，所以要带上/
 */




@WebServlet("/system/usersLoginServlet")
public class UsersLoginServlet extends HttpServlet {


    IUsersService iUsersService=new UsersServiceImp();


    @Override
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
//            获取请求里面属性，封装进bean中
      Users tUsers = RequestBeanUtils.requestToBean(request, Users.class);//请求，类类型对象（bean对象的类类型）
        System.out.print("获取请求的账户和密码");
        System.out.println(tUsers);


        //调用Service层数据
            Users  users= iUsersService.login(tUsers);
            /*
            进行非空判断
            设置状态码可用
            调用dao层方法查询完整信息,封装成UsersBean，将密码设置成空
            返回这最后的bean
             */
            System.out.println("查询并封装后的数据：："+users);
            if(users!=null){
                //将数据存入到session中 ,并进行跳转到首页(index.jsp) 注意是session域 整个会话中
               HttpSession session = request.getSession();
               session.setAttribute("users",users);


               //如果登陆成功，那么就查询错对应的权限菜单
//                调用service层查询方法，该方法逻辑是直接调用dao层通过role_id查询menu权限的方法
               List<Menu>   menuList= iUsersService.selectMenu(users.getRoleId());
                //在将对应的权限存入到Seesin中
                session.setAttribute("menuList",menuList);
//                获取图形报表
                List<Salary> salaryList=iUsersService.selectImgs(users.getUsersId());
                session.setAttribute("salaryImg",salaryList);
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
