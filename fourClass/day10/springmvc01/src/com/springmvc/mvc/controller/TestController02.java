package com.springmvc.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/TestController02")
public class TestController02 {

    @RequestMapping("/Test01/{name}/{age}")
    public  String Test01(@PathVariable("name") String name, @PathVariable("age") Integer  age){
        System.out.println(name+"=="+age);
        return  "sucess";
    }


}
