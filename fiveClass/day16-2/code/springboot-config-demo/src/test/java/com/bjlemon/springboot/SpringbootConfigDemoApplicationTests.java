package com.bjlemon.springboot;

import com.bjlemon.springboot.domain.Person;
import com.bjlemon.springboot.domain.Student;
import com.bjlemon.springboot.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class SpringbootConfigDemoApplicationTests {

    /*@Autowired
    private User user;*/

    @Autowired
    private Person person;

    @Autowired
    private Student student;

    @Test
    void contextLoads() {
        System.out.println(this.person);
        Arrays.stream(this.student.getInters()).forEach(System.out::println);

    }

}
