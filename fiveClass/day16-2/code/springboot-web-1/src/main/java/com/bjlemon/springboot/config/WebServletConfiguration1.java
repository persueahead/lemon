package com.bjlemon.springboot.config;

import com.bjlemon.springboot.web.filter.DemoFilter;
import com.bjlemon.springboot.web.listener.DemoListener;
import com.bjlemon.springboot.web.servlet.DemoServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.util.EnumSet;

//@Configuration
public class WebServletConfiguration1 {

    @Bean
    public ServletRegistrationBean<DemoServlet> servletServletRegistrationBean() {
        ServletRegistrationBean<DemoServlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new DemoServlet());
        servletRegistrationBean.addUrlMappings("/demo");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<DemoFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<DemoFilter> filterRegistrationBean = new FilterRegistrationBean<DemoFilter>();
        filterRegistrationBean.setFilter(new DemoFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<DemoListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<DemoListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>();
        listenerRegistrationBean.setListener(new DemoListener());
        return listenerRegistrationBean;
    }
}
