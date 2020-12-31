package com.bj.springmvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController01 {


    @RequestMapping("/test002")
    public   String test002(){
        System.out.println("我执行了这个方法:test002()");
        return  "redirect:success.jsp";
    }

    /**
 *
 */
@RequestMapping("/test001")
public   String test001(){
    System.out.println("我执行了这个方法:test001()");
    return  "forward:/success.jsp";
}


}
