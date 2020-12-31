package com.bjlemon.springboot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName MyBatisPlusConfiguration.java
 * @Description TODO
 * @createTime 2020年01月12日 21:58:00
 */
@Configuration
public class MyBatisPlusConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
