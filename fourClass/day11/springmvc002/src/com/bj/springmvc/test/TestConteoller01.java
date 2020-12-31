package com.bj.springmvc.test;

import com.bj.springmvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestConteoller01 {
    @RequestMapping("/test005")
    public   String  test005(HttpServletRequest  request, HttpServletResponse  response){
        System.out.println(request.getParameter("name"));
        return  "success";////就是跳转
    }



    @RequestMapping("/test004")
    public   String  test004(Student  student){
        System.out.println(student);

        return  "success";
    }


    @RequestMapping("/test003")
    public   String  test003(@CookieValue(value = "JSESSIONID",required = false,defaultValue = "no  ......") String  cookie){
        System.out.println(cookie);

        return  "success";
    }


    @RequestMapping("/test002")
    public   String  test002(@RequestHeader("Accept-Language") String  language){
        System.out.println(language);

        return  "success";
    }


    @RequestMapping("/test001")
    public   String  test001(@RequestParam("name") String  name,
                             @RequestParam(value = "age",required = false,defaultValue = "123")   int age
                             ){
        System.out.println(name + "：：" + age);

        return  "success";
    }


}
