package com.bjlemon.ssm.web.resolver;

import com.bjlemon.ssm.exception.SsmException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SsmExceptionHandlerResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex != null) {
            if (ex instanceof SsmException) {
                SsmException ssmException = (SsmException) ex;
                String message = ssmException.getMessage();
                modelAndView.addObject("errorMessage", message);
                modelAndView.setViewName("common/error");
            }
        }
        return modelAndView;
    }
}
