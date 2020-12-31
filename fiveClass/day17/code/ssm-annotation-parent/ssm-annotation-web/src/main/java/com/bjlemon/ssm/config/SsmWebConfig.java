package com.bjlemon.ssm.config;

import com.bjlemon.ssm.web.converter.CustomDateConverter;
import com.bjlemon.ssm.web.resolver.SsmExceptionHandlerResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName SsmWebConfig.java
 * @Description TODO
 * @createTime 2020年01月02日 20:46:00
 */
@Configuration
@ComponentScan(value = "com.bjlemon.ssm", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
})
@PropertySource(value = "classpath:conf.properties")
@EnableWebMvc
public class SsmWebConfig implements WebMvcConfigurer {

    @Value("${date.patterns}")
    private String patterns;

    /**
     * @description 配置视图解析器
     * @author admin
     * @updateTime 2020/1/2 21:13
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().prefix("/WEB-INF/pages/").suffix(".jsp").viewClass(JstlView.class);
    }

    /**
     * @description 静态资源放行
     * @author admin
     * @updateTime 2020/1/2 21:14
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new SsmExceptionHandlerResolver());
    }

    /**
     * @description 添加自定义转换器
     * @author admin
     * @updateTime 2020/1/2 21:17
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        CustomDateConverter customDateConverter = new CustomDateConverter();
        customDateConverter.setPatterns(this.patterns);
        registry.addConverter(customDateConverter);
    }
}
