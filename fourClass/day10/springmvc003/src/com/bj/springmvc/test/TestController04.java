package com.bj.springmvc.test;

import com.bj.spring.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class TestController04 {



@RequestMapping("/TestController04/test001")
public   String test001( Users users){
    System.out.println("我执行了这个方法:test001()"+users);
    return  "success";
}

/**
 *
 */
@InitBinder
public   void test(WebDataBinder webDataBinder){
    webDataBinder.setDisallowedFields("name");

}

}
