package com.bjlemon.security.web.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CustomExceptionHandlerResolver.java
 * @Description TODO
 * @createTime 2020年02月15日 21:38:00
 */
@ControllerAdvice
public class CustomExceptionHandlerResolver {

    @ExceptionHandler(AccessDeniedException.class)
    public String handleException(HttpSession session) {
        session.setAttribute("errorMessage", "您没有权限！");
        return "redirect:/error";
    }
}
