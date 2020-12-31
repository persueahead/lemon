package com.bj.springmvc.test;

import com.bj.springmvc.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TestConteoller04 {





    @RequestMapping("/TestConteoller04/test001")
    public   String  test001(){


        return  "success";
    }


}
