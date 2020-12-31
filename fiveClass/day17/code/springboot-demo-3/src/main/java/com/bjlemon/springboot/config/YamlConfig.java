package com.bjlemon.springboot.config;

import com.bjlemon.springboot.domain.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName YamlConfig.java
 * @Description TODO
 * @createTime 2020年01月04日 20:42:00
 */
@Configuration
@ConfigurationProperties(prefix = "person")
public class YamlConfig {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName(this.name);
        return person;
    }

}
