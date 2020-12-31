package com.bjlemon.springboot.config;

import com.bjlemon.springboot.domain.Person;
import com.bjlemon.springboot.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "person")
public class YamlConfig {

    private String username;
    private String password;
    private String info;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /*@Bean
    public User user() {
        User user = new User();
        user.setName(this.username);
        user.setPassword(this.password);
        user.setInfo(this.info);
        return user;
    }*/

    @Bean
    public Person person() {
        Person person = new Person();
        person.setUsername(this.username);
        person.setPassword(this.password);
        person.setInfo(this.info);
        return person;
    }
}
