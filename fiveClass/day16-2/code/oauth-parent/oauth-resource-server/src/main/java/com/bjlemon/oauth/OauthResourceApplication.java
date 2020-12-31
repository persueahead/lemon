package com.bjlemon.oauth;

import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bjlemon.oauth.mapper")
public class OauthResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthResourceApplication.class, args);
    }
}
