package com.bj.springmvc.test;

import com.bj.spring.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class TestController03 {



@RequestMapping("/TestController03/test001")
public   String test001(@RequestParam("uses") Users users){
    System.out.println("我执行了这个方法:test001()"+users);
    return  "success";
}


}
