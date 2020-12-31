package com.department.manager.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;
import java.nio.file.AccessDeniedException;

/**
 * 另外一种处理异常的方法——自定义全局异常处理器
 */
@ControllerAdvice
public class CustomExceptionHandlerResolver {
    /**
     * 权限异常
     * @param session
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public String handleException(HttpSession session) {
        session.setAttribute("errorMessage", "no authorities");
        return "redirect:/error";
    }

    /**
     * 空指异常
     * @param session
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public String handlerNullException(HttpSession session){
        session.setAttribute("errorMessage","nullPoint");
        return "redirect:/error";
    }

}
