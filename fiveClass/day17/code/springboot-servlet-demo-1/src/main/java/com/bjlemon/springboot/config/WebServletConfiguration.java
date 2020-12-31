package com.bjlemon.springboot.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName WebServletConfiguration.java
 * @Description TODO
 * @createTime 2020年01月07日 21:39:00
 */
@Configuration
public class WebServletConfiguration implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /*ServletRegistration.Dynamic helloworldServlet = servletContext.addServlet("HelloworldServlet", HelloworldServlet.class);
        helloworldServlet.addMapping("/helloworld", "/demo");
        helloworldServlet.setLoadOnStartup(3);
        helloworldServlet.setInitParameter("username", "zhangsan");
        helloworldServlet.setInitParameter("password", "admin");

        FilterRegistration.Dynamic helloworldFilter = servletContext.addFilter("HelloworldFilter", HelloworldFilter.class);
        helloworldFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

        servletContext.addListener(HelloworldListener.class);*/
    }
}
