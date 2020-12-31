package com.bjlemon.springboot.web.controller;

import com.bjlemon.springboot.domain.Person;
import com.bjlemon.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName HelloworldController.java
 * @Description TODO
 * @createTime 2020年01月09日 20:50:00
 */
@Controller
@RequestMapping("/thymeleaf")
public class HelloworldController {

    @Autowired
    private PersonService personService;

    @GetMapping("/helloworld")
    public String helloworld(Model model) {
        model.addAttribute("info", "thymeleaf is so good");
        return "helloworld";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Person> personList = this.personService.findAllPersonList();
        model.addAttribute(personList);
        return "person_list";
    }

}
