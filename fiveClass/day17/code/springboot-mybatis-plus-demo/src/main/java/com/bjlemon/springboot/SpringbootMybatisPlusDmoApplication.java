package com.bjlemon.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.bjlemon.springboot.mapper"})
public class SpringbootMybatisPlusDmoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusDmoApplication.class, args);
    }

}