package com.bjlemon.springboot.config;

import com.bjlemon.springboot.web.filter.HelloworldFilter;
import com.bjlemon.springboot.web.listener.HelloworldListener;
import com.bjlemon.springboot.web.servlet.HelloworldServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName WebServletConfiguration.java
 * @Description TODO
 * @createTime 2020年01月07日 21:39:00
 */
@Configuration
public class WebServletConfiguration1 {

    @Bean
    public ServletRegistrationBean<HelloworldServlet> servletServletRegistrationBean() {
        ServletRegistrationBean<HelloworldServlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new HelloworldServlet());
        servletRegistrationBean.addUrlMappings("/helloworld", "/demo");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<HelloworldFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<HelloworldFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new HelloworldFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<HelloworldListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<HelloworldListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        servletListenerRegistrationBean.setListener(new HelloworldListener());
        return servletListenerRegistrationBean;
    }
}
