package com.bjlemon.springboot.web.listener; /**
 * @ClassName ${NAME}.java
 * @author jeffzhou
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年01月07日 21:23:00
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HelloworldListener implements ServletContextListener {

    public HelloworldListener() {
        System.out.println("HelloworldListener()");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器初始化了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁了");
    }
}
