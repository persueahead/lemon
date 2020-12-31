package com.bjlemon.utiles;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class CharSerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //获取数据  字符集格式化
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpServletRequest  httpServletRequest=(HttpServletRequest)req;
        String uri = httpServletRequest.getRequestURI();
//        非样式相关，设置响应头为text/html;charset=utf-8
        if (!uri.contains("/resource/")){
            resp.setContentType("text/html;charset=utf-8");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
