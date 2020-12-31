package com.department.manager.web.handler;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomAuthenticFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession(true);
        if (e instanceof DisabledException) {
            session.setAttribute("errorMessage", "账户不可用");
        } else if (e instanceof AccountExpiredException) {
            session.setAttribute("errorMessage", "账户过期");
        } else if (e instanceof CredentialsExpiredException) {
            session.setAttribute("errorMessage", "账户密码过期");
        } else if (e instanceof LockedException) {
            session.setAttribute("errorMessage", "账户已锁住");
        } else if (e instanceof BadCredentialsException) {
            session.setAttribute("errorMessage", "密码错误");
        } else if (e instanceof InternalAuthenticationServiceException) {
            session.setAttribute("errorMessage", "账户不存在");
        }
//        动态的携带错误信息跳转错误页面
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/error");
    }
}
