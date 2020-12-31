package com.bj.spring.test01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdbcTest {

   @Value("#{systemProperties['user.language']}")
    private  String  language;

    @Override
    public String toString() {
        return "JdbcTest{" +
                "language='" + language + '\'' +
                '}';
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
