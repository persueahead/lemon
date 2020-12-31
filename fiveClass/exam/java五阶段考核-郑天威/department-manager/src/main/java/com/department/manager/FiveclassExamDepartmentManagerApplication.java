package com.department.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan(value = "com.department.manager.mapper")
@EnableGlobalMethodSecurity(
        jsr250Enabled = true,
        prePostEnabled = true,
        securedEnabled = true
)
public class FiveclassExamDepartmentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiveclassExamDepartmentManagerApplication.class, args);

    }

}
