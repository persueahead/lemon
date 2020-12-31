package com.bjlemon.springboot;

import com.bjlemon.springboot.domain.Person;
import com.bjlemon.springboot.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemo3ApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private User user;

    @Test
    void contextLoads() {
        System.out.println(this.person);
        System.out.println(this.user);
    }

}
