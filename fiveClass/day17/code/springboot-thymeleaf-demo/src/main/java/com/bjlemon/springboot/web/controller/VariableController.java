package com.bjlemon.springboot.web.controller;

import com.bjlemon.springboot.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName VariableController.java
 * @Description TODO
 * @createTime 2020年01月09日 21:34:00
 */
@Controller
@RequestMapping("/variable")
public class VariableController {

    @GetMapping("/test1")
    public String test1(HttpSession session) {
        session.setAttribute("person", new Person(1, "zhangsan", "admin", 12.34F, new Date()));
        return "variable";
    }

    @GetMapping("/test2")
    public String test2(Model model) {
        model.addAttribute("id", 1000);
        return "variable2";
    }

}
