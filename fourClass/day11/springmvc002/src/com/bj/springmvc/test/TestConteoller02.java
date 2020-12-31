package com.bj.springmvc.test;

import com.bj.springmvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Controller
@SessionAttributes(value = {"mapkey","mapkey1"},types = {Date.class,String.class})
public class TestConteoller02 {
    @RequestMapping("/TestConteoller02/test006")
    public   String   test006(Model map){

        map.addAttribute("mapkey",new Date());
        map.addAttribute("mapkey1","王麻子");
        map.addAttribute("mapkey2","李四");
        map.addAttribute("mapkey3","王老五");

        return  "success";
    }


    @RequestMapping("/TestConteoller02/test005")
    public   String   test005(Model map){

        map.addAttribute("mapkey",new Date());

        return  "success";
    }
    @RequestMapping("/TestConteoller02/test004")
    public   String   test004(ModelMap  map){

        map.addAttribute("KEY",new Date());

        return  "success";
    }

    @RequestMapping("/TestConteoller02/test003")
    public   String   test003(Map<String,Object> map){

        map.put("map","TestConteoller02/test003");

        return  "success";
    }

    @RequestMapping("/TestConteoller02/test001")
    public   ModelAndView  test001(){
        ModelAndView view = new ModelAndView();
        view.addObject("msg",new Date());
        view.addObject("name","asdasdas");
        view.addObject("age",123123);
        view.setViewName("success");  //就是跳转
        return  view;
    }


}
