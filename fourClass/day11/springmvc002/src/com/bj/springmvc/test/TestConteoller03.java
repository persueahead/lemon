package com.bj.springmvc.test;

import com.bj.springmvc.pojo.Student;
import com.bj.springmvc.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@Controller
public class TestConteoller03 {



    /**
     *
     */
    @ModelAttribute
    public   void test(@RequestParam(value = "id",required = false
    ) Integer id,Map<String,Object> map){
       //相当于从数据库中查询出来的数据
        Users user = new Users(id, "隔壁老陈", 123);
        map.put("users",user);
    }



    @RequestMapping("/TestConteoller03/test001")
    public   String  test001(Users  users){

        System.out.println("我们要修改提交的数:"+users);

        return  "success";
    }


}
