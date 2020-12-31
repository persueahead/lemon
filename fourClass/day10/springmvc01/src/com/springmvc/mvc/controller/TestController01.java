package com.springmvc.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/TestController01")
public class TestController01 {
    @RequestMapping(value = "/test07/*/asd?/**")
    public   String test07(){
        System.out.println("test07");
        return  "sucess";

    }

    @RequestMapping(value = "/test06",params = {"name","age!=10"}
    ,headers = {"Accept-Language=zh,en-US;q=0.9,en;q=0.8"}
    )
    public   String test06(){
        System.out.println("test06");
        return  "sucess";

    }

    @PostMapping("/test05")
    public   String test05(){
        System.out.println("PostMapping.POST");
        return  "sucess";

    }
    @GetMapping("/test04")
    public   String test04(){
        System.out.println("GetMapping");
        return  "sucess";

    }

    @RequestMapping(value = "/test03",method = RequestMethod.POST)
    public   String test03(){
        System.out.println("RequestMethod.POST");
        return  "sucess";

    }
    @RequestMapping(value = "/test02",method = RequestMethod.GET)
    public   String test02(){
        System.out.println("RequestMethod.GET");
        return  "sucess";

    }
    @RequestMapping("/Test01")
    public  String Test01(){
        System.out.println("我执行了请求的方法");
        return  "sucess";
    }


}
