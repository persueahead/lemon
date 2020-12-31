package com.bjlemon.ssm.web.initializer;

import com.bjlemon.ssm.config.SsmRootConfig;
import com.bjlemon.ssm.config.SsmWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName SsmServletContainerInitializer.java
 * @Description TODO
 * @createTime 2020年01月02日 20:44:00
 */
public class SsmServletContainerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * @description 加载Spring的Root容器（applicationContext.xml）
     * @author admin
     * @updateTime 2020/1/2 20:45
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SsmRootConfig.class};
    }

    /**
     * @description 加载Spring的小容器（springmvc.xml）
     * @author admin
     * @updateTime 2020/1/2 20:47
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SsmWebConfig.class};
    }

    /**
     *
     * @return 前端控制器匹配地址类型
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
