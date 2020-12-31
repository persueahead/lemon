package com.bj.springmvc.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ThisArithmeticException {
    //@ExceptionHandler({ArithmeticException.class})
    public ModelAndView test002(Exception  ex){
        System.out.println(ex);
        ModelAndView view = new ModelAndView();
        view.setViewName("error");
        view.addObject("exception",ex.getMessage());
        return   view;
    }

}
