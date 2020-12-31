package com.bjlemon.utiles;

import com.bjlemon.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
          //获取用户的信息数据
        HttpServletRequest  httpServletRequest=(HttpServletRequest)req;
        HttpServletResponse httpServletResponse=(HttpServletResponse)resp;
        HttpSession session = httpServletRequest.getSession();
        //获取当前用户的信息
        Users users= (Users) session.getAttribute("users");
        //获取对应的地址
        String uri = httpServletRequest.getRequestURI();
        if(users !=null){
            chain.doFilter(req, resp);
        }else if(uri.contains("system/usersLoginServlet")){
            chain.doFilter(req, resp);
        }else if(uri.contains("resource")){
            chain.doFilter(req, resp);
        }else if(uri.contains("login.jsp")){
            chain.doFilter(req, resp);
        }else{
            httpServletResponse.sendRedirect("/view/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
