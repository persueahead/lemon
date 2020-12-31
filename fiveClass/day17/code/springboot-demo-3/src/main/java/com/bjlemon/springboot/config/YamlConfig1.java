package com.bjlemon.springboot.config;

import com.bjlemon.springboot.domain.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName YamlConfig.java
 * @Description TODO
 * @createTime 2020年01月04日 20:42:00
 */
@Configuration
@ConfigurationProperties(prefix = "user")
public class YamlConfig1 {

    private String userName;
    private Integer age;
    //    private String[] inters;
    private List<String> inters;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

   /* public String[] getInters() {
        return inters;
    }

    public void setInters(String[] inters) {
        this.inters = inters;
    }*/

    public List<String> getInters() {
        return inters;
    }

    public void setInters(List<String> inters) {
        this.inters = inters;
    }

    @Bean
    public User user() {
        User user = new User();
        user.setName(this.userName);
        user.setAge(this.age);
        user.setInters(this.inters);
        return user;
    }

}
