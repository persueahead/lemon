package com.bj.springmvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController001 {




    @RequestMapping("/TestController001/test002")
    public   String  test002(@RequestParam("id") int  id){
       // System.out.println(20 / id);
        if(id==0){
            throw new MyThisException();
        }
        return  "lsit";
    }

    /**
     *
     */
    @RequestMapping("/TestController001/test001")
    public   String  test001(@RequestParam("id") int  id){
        System.out.println(20 / id);
        return  "lsit";
    }


    //进行创建一个处理异常的方法

    /**
     *
     */
 /*   @ExceptionHandler({ArithmeticException.class})
    public ModelAndView test002(Exception  ex){
        System.out.println(ex);
        ModelAndView view = new ModelAndView();
        view.setViewName("error");
        view.addObject("exception",ex.getMessage());
        return   view;
    }*/






    /**
     *
     */
    @RequestMapping("/TestController001/test")
    public   String  test(){
        System.out.println(" public   String  test()");

        return  "lsit";


    }
}
