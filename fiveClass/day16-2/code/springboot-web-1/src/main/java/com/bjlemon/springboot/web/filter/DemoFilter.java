package com.bjlemon.springboot.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "DemoFilter")
public class DemoFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        System.out.println("过滤器执行了");

        chain.doFilter(request,response);

        System.out.println("过滤器执行完毕");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
