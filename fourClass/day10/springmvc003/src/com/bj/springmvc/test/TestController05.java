package com.bj.springmvc.test;

import com.bj.spring.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TestController05 {



@RequestMapping("/TestController05/test001")
public   String test001( Users users){
    System.out.println("我执行了这个方法:test001()"+users);
    return  "success";
}


}
