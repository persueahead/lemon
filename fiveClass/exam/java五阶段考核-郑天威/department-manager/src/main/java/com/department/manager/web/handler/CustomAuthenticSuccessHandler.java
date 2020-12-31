package com.department.manager.web.handler;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 夜神
 * @discription 自定义认证成功后的处理，要实现AuthenticationSuccessHandler接口
 */
public class CustomAuthenticSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
//        he Principal being authenticated or the authenticated principal after authentication.
//        getPrincipal的实例是UserDetails的对象，只能转security.UserDetails.User
        User user = (User) authentication.getPrincipal();
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("manager", user);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index");
    }
}
