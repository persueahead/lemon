package com.bj.springmvc.test;

import com.bj.spring.pojo.Student;
import com.bj.spring.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class TestCotriller001 {









    @RequestMapping("/TestCotriller001/test002")
    public   String  test002(@Valid Student student, BindingResult   result){

        System.out.println(student);
        if(result.getErrorCount()>0){
            for (FieldError error : result.getFieldErrors()) {
                System.out.println("出了错了" + error.getField() + "：：" + error.getDefaultMessage()+"\t");
            }
        }
        return "success";
    }
    /**
     *
     */
     @RequestMapping("/TestCotriller001/test001")
    public   String  test001(Users users, BindingResult   result){

         System.out.println(users);
         if(result.getErrorCount()>0){
             for (FieldError error : result.getFieldErrors()) {
                 System.out.println("出了错了" + error.getField() + "：：" + error.getDefaultMessage()+"\t");
             }
         }
         return "success";
    }
}
