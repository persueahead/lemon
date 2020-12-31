package com.bjlemon.security.web.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CustomAuthenticationSuccessHandler.java
 * @Description TODO
 * @createTime 2020年02月11日 20:36:00
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);

        response.sendRedirect(request.getContextPath() + "/index");
    }
}
