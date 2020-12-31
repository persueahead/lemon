package com.bjlemon.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringbootSecurityDemoApplicationTests {

    @Test
    void contextLoads() {
        String password = new BCryptPasswordEncoder().encode("admin");
        System.out.println(password);
    }

}
