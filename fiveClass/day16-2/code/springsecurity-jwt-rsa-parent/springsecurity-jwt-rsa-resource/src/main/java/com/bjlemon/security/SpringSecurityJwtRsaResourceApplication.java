package com.bjlemon.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true, securedEnabled = true)
public class SpringSecurityJwtRsaResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtRsaResourceApplication.class, args);
    }
}
