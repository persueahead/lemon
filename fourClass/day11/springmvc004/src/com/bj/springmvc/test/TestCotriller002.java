package com.bj.springmvc.test;

import com.bj.spring.pojo.Student;
import com.bj.spring.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartResolver;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class TestCotriller002 {





     @RequestMapping("/TestCotriller002/test001")
     @ResponseBody
    public ArrayList<Users> test001(Users users){
         System.out.println(users);
         //调用Service层，当然这里的Service数据，省略不写,

         //进行模拟Service中返回的数据
         ArrayList<Users> objects = new ArrayList<>();
         for (int i = 0; i < 5; i++) {
             objects.add(users);
         }
         return objects;
    }
}
