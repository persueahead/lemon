package com.bjlemon.springboot.web.handler;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CustomAuthenticationFailureHandler.java
 * @Description TODO
 * @createTime 2020年02月11日 20:42:00
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        if (exception instanceof DisabledException) {
            session.setAttribute("errorMessage", "账户不可用");
        } else if (exception instanceof AccountExpiredException) {
            session.setAttribute("errorMessage", "账户过期");
        } else if (exception instanceof CredentialsExpiredException) {
            session.setAttribute("errorMessage", "账户凭证过期");
        } else if (exception instanceof LockedException) {
            session.setAttribute("errorMessage", "账户已锁住");
        } else if (exception instanceof InternalAuthenticationServiceException) {
            session.setAttribute("errorMessage", "账户不存在");
        } else if (exception instanceof BadCredentialsException) {
            session.setAttribute("errorMessage", "账户凭证错误");
        }
        response.sendRedirect(request.getContextPath() + "/error");
    }
}
