package com.bjlemon.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringbootProfileDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProfileDemoApplication.class, args);
    }

}
