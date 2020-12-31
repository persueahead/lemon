package com.bjlemon.springboot.config;

import com.bjlemon.springboot.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
@PropertySource(value = "classpath:conf.properties")
public class PropertyConfig {

    @Value("${user.username}")
    private String name;

    @Bean
    public User user() {
        User user = new User();
        user.setName(this.name);
        return user;
    }

}
