package com.bjlemon.sys.system.controller.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/system/outLoginServlet")
public class OutLoginServlet extends HttpServlet {
    /**
     * 清空session域属性，删除菜单，然后返回登录页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //进行清空Session中的数据
        request.getSession().removeAttribute("users");
        request.getSession().removeAttribute("menuList");
        request.getSession().removeAttribute("salaryImg");
        response.sendRedirect("/view/login.jsp");
    }
}
