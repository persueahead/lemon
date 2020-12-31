package com.bj.springmvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController002 {
    @RequestMapping("/TestController002/test")
    public   String   test(@RequestParam ("id") int id){
        String[]  str=   new String[5];
        System.out.println(str[id]);
        return "lsit";
    }
}
