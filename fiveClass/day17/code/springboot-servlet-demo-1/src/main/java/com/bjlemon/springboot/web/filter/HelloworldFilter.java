package com.bjlemon.springboot.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO
 * @createTime 2020年01月07日 21:21:00
 */
public class HelloworldFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("HelloworldFilter destroy()");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        System.out.println("HelloworldFilter begin");

        chain.doFilter(request, response);

        System.out.println("HelloworldFilter end");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("HelloworldFilter init()");
    }

}
