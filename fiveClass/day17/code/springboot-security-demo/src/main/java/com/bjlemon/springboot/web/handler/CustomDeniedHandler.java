package com.bjlemon.springboot.web.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CustomDeniedHandler.java
 * @Description TODO
 * @createTime 2020年02月15日 21:31:00
 */
public class CustomDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        session.setAttribute("errorMessage", "您没有权限！");
        response.sendRedirect("/error");
    }
}
