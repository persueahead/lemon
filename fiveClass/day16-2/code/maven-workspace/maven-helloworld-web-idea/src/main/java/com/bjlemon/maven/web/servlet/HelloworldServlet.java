package com.bjlemon.maven.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName HelloworldServlet.java
 * @Description TODO
 * @createTime 2020年02月29日 20:35:00
 */
@WebServlet(name = "HelloworldServlet", urlPatterns = {"/helloworld", "/demo"}, initParams = {
        @WebInitParam(name = "username", value = "zhangsan"),
        @WebInitParam(name = "password", value = "admin")
}, loadOnStartup = 3)
public class HelloworldServlet extends HttpServlet {

    /*@Override
    public void init() throws ServletException {
        String username = this.getInitParameter("username");
        String password = this.getInitParameter("password");
        System.out.println(username + "-----" + password);
    }*/

    @Override
    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        System.out.println(username + "-----" + password);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("info", "Helloworld Maven");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
