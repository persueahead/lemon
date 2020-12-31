package com.bjlemon.springboot.resolver;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomExceptionHandlerResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex != null) {
            HttpSession session = request.getSession(true);
            if (ex.getClass() == AccessDeniedException.class) {
                AccessDeniedException accessDeniedException = (AccessDeniedException) ex;
                session.setAttribute("errorMessage",accessDeniedException.getMessage());
                modelAndView.setViewName("redirect:/error");
            }
        }
        return modelAndView;
    }
}
