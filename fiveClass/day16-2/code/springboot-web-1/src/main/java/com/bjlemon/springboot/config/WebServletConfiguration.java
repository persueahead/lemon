package com.bjlemon.springboot.config;

import com.bjlemon.springboot.web.filter.DemoFilter;
import com.bjlemon.springboot.web.listener.DemoListener;
import com.bjlemon.springboot.web.servlet.DemoServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.util.EnumSet;

//@Configuration
public class WebServletConfiguration implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Servlet集成
        ServletRegistration.Dynamic demoServlet = servletContext.addServlet("DemoServlet", DemoServlet.class);
        demoServlet.addMapping("/demo");
        demoServlet.setLoadOnStartup(3);

        // 过滤器集成
        FilterRegistration.Dynamic demoFilter = servletContext.addFilter("DemoFilter", DemoFilter.class);
        demoFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");

        // 监听器集成
        servletContext.addListener(DemoListener.class);

    }
}
