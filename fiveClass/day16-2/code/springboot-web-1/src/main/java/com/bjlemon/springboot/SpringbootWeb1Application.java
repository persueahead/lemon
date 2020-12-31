package com.bjlemon.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootWeb1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb1Application.class, args);
    }

}
