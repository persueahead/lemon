package com.bjlemon.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan(basePackages = "com.bjlemon.springboot.mapper")
@EnableGlobalMethodSecurity(jsr250Enabled = true,prePostEnabled = true,securedEnabled = true)
public class SpringbootSpringsecurityDemoApplication implements ApplicationRunner, CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringsecurityDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner run()");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner run()");
    }
}
