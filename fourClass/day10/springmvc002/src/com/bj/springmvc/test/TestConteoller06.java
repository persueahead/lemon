package com.bj.springmvc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class TestConteoller06 {


    @RequestMapping("/TestConteoller06/test002")
    public   String  test002(Locale locale){


        return  "thisMyView";
    }

 /*   @Autowired
  private ResourceBundleMessageSource  messageSource;



    @RequestMapping("/TestConteoller05/test001")
    public   String  test001(Locale locale){
        String message = messageSource.getMessage("i18n.usersname", null, locale);
        System.out.println(message);

        return  "success";
    }*/


}
