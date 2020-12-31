package com.bj.springmvc.test;

import com.bj.spring.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class TestCotriller003 {





     @RequestMapping("/TestCotriller003/test001")
    public String test001(@RequestParam("desc") String desc
             , @RequestParam("file")MultipartFile  file) throws IOException {

            if(!file.isEmpty()){
                System.out.println("desc::" + desc);
                System.out.println("file.getOriginalFilename()"+file.getOriginalFilename());

                System.out.println("file.getInputStream()"+file.getInputStream());
            }



         return "success";
    }
}
