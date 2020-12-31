package com.springmvc.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/TestController03")
public class TestController03 {

    @RequestMapping(value="/Test04DELETE/{name}",method = RequestMethod.DELETE)
    public  String Test04(@PathVariable("name") String name){
        System.out.println("RequestMethod.DELETE"+name);
        System.out.println("RequestMethod.DELETE");
        return  "sucess";
    }
    @RequestMapping(value="/Test03PUT/{name}",method = RequestMethod.PUT)
    public  String Test03(@PathVariable("name") String name){
        System.out.println("RequestMethod.PUT"+name);
        System.out.println("RequestMethod.PUT");
        return  "sucess";
    }
    @RequestMapping(value="/Test02POST/{name}",method = RequestMethod.POST)
    public  String Test02(@PathVariable("name") String name){
        System.out.println("RequestMethod.POST");
        System.out.println("RequestMethod.POST"+name);
        return  "sucess";
    }
    @RequestMapping(value="/Test01GET/{name}",method = RequestMethod.GET)
    public  String Test01(@PathVariable("name") String name){
        System.out.println("RequestMethod.GET");
        System.out.println("RequestMethod.GET"+name);
        return  "sucess";
    }


}
