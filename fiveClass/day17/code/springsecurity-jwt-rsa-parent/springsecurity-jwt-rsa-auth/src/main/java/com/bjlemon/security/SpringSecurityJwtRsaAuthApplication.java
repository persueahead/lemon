package com.bjlemon.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName SpringSecurityJwtRsaAuthApplication.java
 * @Description TODO
 * @createTime 2020年02月20日 20:59:00
 */
@SpringBootApplication
@MapperScan(value = "com.bjlemon.security.mapper")
public class SpringSecurityJwtRsaAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtRsaAuthApplication.class, args);
    }


}
