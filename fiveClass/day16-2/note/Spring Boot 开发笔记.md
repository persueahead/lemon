





Spring Boot 开发笔记

## 学习内容

## 1.Spring Boot概述

## 2.Spring Boot入门程序

## 3.Spring Boot配置细节

## 4.Spring Boot日志系统

## 5.Spring Boot与Web整合

## 6.Spring Boot与MyBatis整合

## 7.Spring Boot与JPA整合

## 8.Spring Boot与认证授权框架的整合（Spring Security）

## 9.Spring Boot与缓存整合（Redis）

## 10.Spring Boot与消息中间件整合（ActiveMQ，RabbitMQ，RocketMQ，Kafka）

## 11.Spring Boot与MongoDB整合

## 12.Spring Boot与Elasticsearch（ELK）

## 13.Spring Boot与任务调度整合（Spring Task，xxl-job，Elastic Job）

## 14.Spring Boot与Dubbo整合

## 15.Spring Boot运维层面的技术（指标、健康检查、Actutor）

## 16.Spring Boot源码分析、配置原理、自定义starter



# 一.Spring Boot概述

## 1. Spring Boot是什么

- Spring Boot基于Spring Framework之上的一个微服务架构开发的框架
- Spring Boot大大简化开发。因为Spring Boot大量的自动配置（与非常多的第三方优秀框架集成）
- Spring Boot顺应了架构设计理念。微服务架构开发使用Spring Boot + Spring Cloud是再合适不过。

```markdown
Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need very little Spring configuration.
```

## 2. Spring Boot特点

```markdown
Create stand-alone Spring applications

Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)

Provide opinionated 'starter' dependencies to simplify your build configuration

Automatically configure Spring and 3rd party libraries whenever possible

Provide production-ready features such as metrics, health checks and externalized configuration

Absolutely no code generation and no requirement for XML configuration
```



# 二.Spring Boot入门程序

## 2.1 手动做法

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent -->
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.5.RELEASE</version>
    </parent>


    <groupId>com.bjlemon</groupId>
    <artifactId>springboot-quickstart-1</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

```properties
server.port=8888
spring.application.name=springboot-quickstart-1
```

```java
@RestController
@RequestMapping("/helloworld")
public class HelloworldController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Helloworld Spring Boot";
    }
}
```

```java
@SpringBootApplication
public class SpringBootQuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQuickstartApplication.class,args);
    }
}
```

## 2.2 向导做法



# 三.配置细节

## 3.1 配置方式

- application.properties
- **application.yml**

## 3.2 YAML详解

### 3.2.1 YAML概述

- YAML全称：YAML ain't a markup language

```markdown
YAML（/ˈjæməl/，尾音类似camel骆驼）是一个可读性高，用来表达数据序列化的格式。YAML参考了其他多种语言，包括：C语言、Python、Perl，并从XML、电子邮件的数据格式（RFC 2822）中获得灵感。Clark Evans在2001年首次发表了这种语言，另外Ingy döt Net与Oren Ben-Kiki也是这语言的共同设计者。当前已经有数种编程语言或脚本语言支持（或者说解析）这种语言。
YAML是"YAML Ain't a Markup Language"（YAML不是一种标记语言）的递归缩写。在开发的这种语言时，YAML 的意思其实是："Yet Another Markup Language"（仍是一种标记语言），但为了强调这种语言以数据做为中心，而不是以标记语言为重点，而用反向缩略语重命名。
```

### 3.2.2 语法

- 键值对。注意：键与值之间必须有“:(空格)”

```yaml
k: v
```

- 以两个空格的缩进控制层次，左对齐的键属于同一级

```yaml
user:
  name: zhangsan
  password: admin
```

- 字面量
    - 如果值中有转义字符，使用引号来进行转义。单引号（不会转义）而双引号会转义

```java
package com.bjlemon.springboot.config;

import com.bjlemon.springboot.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "user")
public class YamlConfig {

    private String username;
    private String password;
    private String info;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Bean
    public User user() {
        User user = new User();
        user.setName(this.username);
        user.setPassword(this.password);
        user.setInfo(this.info);
        return user;
    }
}
```

```yaml
user:
  username: lisi
  password: test
  # 单引号不会转义
  info: 'aaaa\nbbbb'
  # 双引号会转义（换行）
  info: "aaaa\nbbbb“
```

- 对象

```yaml
person: {username: "wangwu",password: "admin"}
```

- 集合

```yaml
#student:
#  inters:
#    - football
#    - basketball
#    - volleyball

student:
  inters: ["football","basketball","volleyball"]
```



## 3.3 Profile

### 3.3.1 概念

- 配置文件可以在不同的环境（dev，test，prod）去切换
- 配置文件有多个，命名规范：application-{profile}.xml。application-dev.xml，application-prod.xml

### 3.3.2 yaml支持多文档化

```yaml
server:
  port: 8888
spring:
  profiles: dev
  
---

server:
  port: 9999
spring:
  profiles: prod
```

### 3.3.3 激活profile

- 一种方式

```yaml
spring:
  profiles:
    active: prod
```

- application-dev.yml

```yaml
server:
  port: 8888
```

- application-prod.yml

```yaml
server:
  port: 9999
```

- 第二种方式

```shell
-Dspring.profiles.active=prod
```

- 第三种方式

```shell
java -jar springboot-profile-demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```

## 3.4 配置文件的加载顺序

### 3.4.1 加载顺序

```markdown
./config/
./
classpath:/config/
classpath:/

1. 从上到下优先级依次降低
2. 配置互补，将所有的配置全部加载，相同的配置高优先级会覆盖低优先级
```

### 3.4.2 通过命令行方式制定运行哪一个配置文件

```shell
java -jar xxx.jar --spring.config.location=classpath:/
```



# 四.日志系统

## 4.1 slf4j

- http://www.slf4j.org/
- simple logging facade for java

```markdown
The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.

Before you start using SLF4J, we highly recommend that you read the two-page SLF4J user manual.

Note that SLF4J-enabling your library implies the addition of only a single mandatory dependency, namely slf4j-api.jar. If no binding is found on the class path, then SLF4J will default to a no-operation implementation.

In case you wish to migrate your Java source files to SLF4J, consider our migrator tool which can migrate your project to use the SLF4J API in just a few minutes.

In case an externally-maintained component you depend on uses a logging API other than SLF4J, such as commons logging, log4j or java.util.logging, have a look at SLF4J's binary-support for legacy APIs.
```

- http://www.slf4j.org/manual.html

![image-20200314202436117](images/image-20200314202436117.png)



## 4.2 slf4j如何进行统一

- 背景：我们的系统中可能会有各种框架（Spring，MyBatis...），而每一个框架用到的日志系统不同（commons-logging，log4j...）。此时如何整合？

![image-20200314203228774](images/image-20200314203228774.png)

- 首先明确最终使用哪一个日志产品，然后需要加入适配层或替换包（jcl-over-slf4j.jar，log4j-over-slf4j.jar，jul-to-slf4j.jar）即可

## 4.3 SpringBoot如何实现日志

![img](images/SNAGHTML3e0f6c.PNG)

## 4.4 logback

- http://logback.qos.ch/

```markdown
Logback is intended as a successor to the popular log4j project, picking up where log4j leaves off.

Logback's architecture is sufficiently generic so as to apply under different circumstances. At present time, logback is divided into three modules, logback-core, logback-classic and logback-access.

The logback-core module lays the groundwork for the other two modules. The logback-classic module can be assimilated to a significantly improved version of log4j. Moreover, logback-classic natively implements the SLF4J API so that you can readily switch back and forth between logback and other logging frameworks such as log4j or java.util.logging (JUL).

The logback-access module integrates with Servlet containers, such as Tomcat and Jetty, to provide HTTP-access log functionality. Note that you could easily build your own module on top of logback-core.
```

- 重要API

    - Appender

    ​      ![image-20200314204436225](images/image-20200314204436225.png)

    - Layout

    ​       ![image-20200314204517412](images/image-20200314204517412.png)

- 默认实现

    ```yaml
    logging:
      level:
        root: debug
    #  file:
    #    path: D:/springboot/
    ```

- 定制日志

    - 类路径下编写自定义的日志配置文件

        ![image-20200314205359135](images/image-20200314205359135.png)

    - 样例

        ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <configuration>
        
            <property name="DEV_HOME" value="c:/logs" />
        
            <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
                <layout class="ch.qos.logback.classic.PatternLayout">
                    <Pattern>
                        %d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
                    </Pattern>
                </layout>
            </appender>
        
            <appender name="FILE-AUDIT"
                class="ch.qos.logback.core.rolling.RollingFileAppender">
                <file>${DEV_HOME}/debug.log</file>
                <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                    <Pattern>
                        %d{yyyy-MM-dd HH:mm:ss} - %msg%n
                    </Pattern>
                </encoder>
        
                <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                    <!-- rollover daily -->
                    <fileNamePattern>${DEV_HOME}/archived/debug.%d{yyyy-MM-dd}.%i.log
                                </fileNamePattern>
                    <timeBasedFileNamingAndTriggeringPolicy
                        class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                        <maxFileSize>10MB</maxFileSize>
                    </timeBasedFileNamingAndTriggeringPolicy>
                </rollingPolicy>
        
            </appender>
        
            <appender name="FILE-ERROR"
                class="ch.qos.logback.core.rolling.RollingFileAppender">
                <file>${DEV_HOME}/error.log</file>
                <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                    <Pattern>
                        %d{yyyy-MM-dd HH:mm:ss} - %msg%n
                    </Pattern>
                </encoder>
        
                <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                    <!-- rollover daily -->
                    <fileNamePattern>${DEV_HOME}/archived/error.%d{yyyy-MM-dd}.%i.log
                                </fileNamePattern>
                    <timeBasedFileNamingAndTriggeringPolicy
                        class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                        <maxFileSize>10MB</maxFileSize>
                    </timeBasedFileNamingAndTriggeringPolicy>
                </rollingPolicy>
        
            </appender>
        
            <!-- Send logs to both console and file audit -->
            <logger name="com.mkyong.web" level="debug"
                additivity="false">
                <appender-ref ref="FILE-AUDIT" />
                <appender-ref ref="STDOUT" />
            </logger>
        
            <root level="error">
                <appender-ref ref="FILE-ERROR" />
            </root>
        
        </configuration>
        ```

        

# 五. Spring Boot与Web集成

## 5.1 SprinBoot如何集成Web

- 自动配置类：XxxWebAutoConfiguration
- 属性类：XxxProperties

​       ![image-20200314211848175](images/image-20200314211848175.png)



## 5.2 静态资源映射规则

### 5.2.1 默认规则

```java
private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
			"classpath:/resources/", "classpath:/static/", "classpath:/public/" };
```

### 5.2.2 定制规则

```properties
spring.resources.static-locations=classpath:/demo/
```

- 一旦定制后，默认配置失效

### 5.2.3 分析源码

![img](images/SNAGHTML74395a.PNG)

- 所有的/webjars/**都会在classpath:/META-INF/resources/webjars下去搜索对应的静态资源



## 5.3 SpringBoot与JSP集成

### 5.3.1 简介

- JSP不推荐使用
- 建议使用模板（Freemarker和Thymeleaf）

### 5.3.2 使用

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
</dependency>

<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

```yaml
server:
  port: 8888
spring:
  application:
    name: springboot-web-1
mvc:
  view:
    prefix: /WEB-INF/views/
    suffix: .jsp
```



## 5.4 SpringBoot与Servlet、Filter和Listener整合

### 5.4.1第一种集成方式

```java
package com.bjlemon.springboot.config;

import com.bjlemon.springboot.web.filter.DemoFilter;
import com.bjlemon.springboot.web.listener.DemoListener;
import com.bjlemon.springboot.web.servlet.DemoServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.util.EnumSet;

@Configuration
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
```

### 5.4.2 第二种方式

```java
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

@Configuration
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
```

### 5.4.3 第三种实现方式

```java
@SpringBootApplication
@ServletComponentScan
public class SpringbootWeb1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb1Application.class, args);
    }

}
```

```java
package com.bjlemon.springboot.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet",urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Helloworld SpringBoot</h1>");
        writer.flush();
        writer.close();
    }
}
```

```java
package com.bjlemon.springboot.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "DemoFilter")
public class DemoFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        System.out.println("过滤器执行了");

        chain.doFilter(request,response);

        System.out.println("过滤器执行完毕");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }
}
```

```java
package com.bjlemon.springboot.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class DemoListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁了");
    }
}
```



## 5.5 SpringBoot与模板的整合

### 5.5.1 模板的概述

- 模板引擎：用户界面与业务数据分离。最终生成静态页面，这样性能好
- 用户界面+数据=结果
- 比JSP更轻量级，渲染效果更好，用户体验更好
- 模板引擎框架：
    - **Freemarker**
    - Velocity
    - **Thymeleaf**

### 5.5.2 Freemarker

- https://freemarker.apache.org/

```markdown
Apache FreeMarker™ is a template engine: a Java library to generate text output (HTML web pages, e-mails, configuration files, source code, etc.) based on templates and changing data. Templates are written in the FreeMarker Template Language (FTL), which is a simple, specialized language (not a full-blown programming language like PHP). Usually, a general-purpose programming language (like Java) is used to prepare the data (issue database queries, do business calculations). Then, Apache FreeMarker displays that prepared data using templates. In the template you are focusing on how to present the data, and outside the template you are focusing on what data to present.
```

 ![image-20200314224459725](images/image-20200314224459725.png)

- SpringBoot与Freemarker整合

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
```

```yaml
server:
  port: 8888
spring:
  application:
    name: springboot-freemarker-demo
  freemarker:
    cache: false
    enabled: true
    suffix: .ftl
    template-loader-path: classpath:/templates/
```



## 5.6 Thymeleaf

### 5.6.1 概述

- https://www.thymeleaf.org/

```markdown
Thymeleaf is a modern server-side Java template engine for both web and standalone environments.

Thymeleaf's main goal is to bring elegant natural templates to your development workflow — HTML that can be correctly displayed in browsers and also work as static prototypes, allowing for stronger collaboration in development teams.

With modules for Spring Framework, a host of integrations with your favourite tools, and the ability to plug in your own functionality, Thymeleaf is ideal for modern-day HTML5 JVM web development — although there is much more it can do.
```

- Java服务器端模板引擎
- 如果服务器端没有提供数据，那么就以静态数据展现，反之就用动态数据覆盖静态数据来展现
- Thymeleaf与前端框架（Vue，React）区别
    - 前端框架基本都使用异步技术，后端会将数据以JSON数据格式发给客户端，页面的展现可能会有延迟。搜索引擎不能搜索数据
    - Thymeleaf是一种后端页面的渲染，然后将结果显示在页面上。搜索引擎能搜索数据

### 5.6.2 SpringBoot与Thymeleaf集成

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

```yaml
server:
  port: 8888
spring:
  application:
    name: springboot-thymeleaf-demo
  thymeleaf:
    enabled: true
    encoding: UTF-8
    cache: false
```

### 5.6.3 Thymeleaf语法

- 简单表达式

​       ![image-20200317203055581](images/image-20200317203055581.png)

- 表达式基本对象

    ![image-20200317203423860](images/image-20200317203423860.png) 

- 表达式工具对象

    ![image-20200317203525238](images/image-20200317203525238.png) 



## 5.7 SpringBoot与模板引擎集成分析源码

### 5.7.1 XxxAutoConfiguration

### 5.7.2 XxxProperties

- FreemarkerAutoConfiguration源码分析

![image-20200317211233785](images/image-20200317211233785.png) 

![image-20200317211357993](images/image-20200317211357993.png) 

- ThymeleafAutoConfiguration源码

![image-20200317211735442](images/image-20200317211735442.png)  



## 5.8 SpringBoot与SpringMVC集成原理

### 5.8.1 自动配置

```markdown
2. Inclusion of ContentNegotiatingViewResolver and BeanNameViewResolver beans.
3. Support for serving static resources, including support for WebJars (covered later in this document)).
4. Automatic registration of Converter, GenericConverter, and Formatter beans.
5. Support for HttpMessageConverters (covered later in this document).
6. Automatic registration of MessageCodesResolver (covered later in this document).
7. Static index.html support.
8. Custom Favicon support (covered later in this document).
9. Automatic use of a ConfigurableWebBindingInitializer bean (covered later in this document).
```

- WebMvcAutoConfiguration类实现了一些默认配置，比如视图解析器、转换器、格式化器、静态资源映射

### 5.8.2 定制配置

- 可以。
- 配置类实现接口（WebMvcConfigurer），此时不能加上@EnableWebMvc

```markdown
If you want to keep those Spring Boot MVC customizations and make more MVC customizations (interceptors, formatters, view controllers, and other features), you can add your own @Configuration class of type WebMvcConfigurer but without @EnableWebMvc.
```

- 如果不想使用SpringBoot与Spring MVC自动配置（外圈接管集成），此时配置类实现接口（WebMvcConfigurer），此时加上@EnableWebMvc

```
If you want to take complete control of Spring MVC, you can add your own @Configuration annotated with @EnableWebMvc, or alternatively add your own @Configuration-annotated DelegatingWebMvcConfiguration as described in the Javadoc of @EnableWebMvc.
```

- **为什么不要加@EnableWebMvc？**

![image-20200317213846165](images/image-20200317213846165.png) 



# 六. SpringBoot与持久化层集成

## 6.1 SpringBoot与MyBatis集成

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.5.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.bjlemon</groupId>
    <artifactId>springboot-mybatis-demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot-mybatis-demo</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.2</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba/druid-spring-boot-starter -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.21</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper-spring-boot-starter -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.13</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.9</version>
        </dependency>

        <dependency>
            <groupId>commons-collections</groupId>
            <artifactId>commons-collections</artifactId>
            <version>3.2.2</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

```yaml
server:
  port: 9999
spring:
  application:
    name: springboot-mybatis-demo

  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql:///springboot_mybatis?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: root
    type: com.alibaba.druid.pool.DruidDataSource
    druid:
      initial-size: 5
      max-active: 20
      min-idle: 5
      max-wait: 60000
mybatis:
  mapper-locations: classpath:/mappers/*.xml
  type-aliases-package: com.bjlemon.springboot.domain
  configuration:
    lazy-loading-enabled: true
    aggressive-lazy-loading: false
    cache-enabled: true
```

```java
@SpringBootApplication
@MapperScan(basePackages = "com.bjlemon.springboot.mapper")
public class SpringbootMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
    }

}
```



## 6.2 SpringBoot与MyBatis-plus集成

### 6.2.1 MP概述

- MP是MyBatis的插件，又称为MyBatis增强
- MP是国内的一个团队开发（baomidou）
- https://github.com/baomidou/mybatis-plus
- https://mybatis.plus/

```markdown
MyBatis-Plus is an powerful enhanced toolkit of MyBatis for simplify development. This toolkit provides some efficient, useful, out-of-the-box features for MyBatis, use it can effectively save your development time.
```

- 特点

```markdown
Fully compatible with MyBatis
Auto configuration on startup
Out-of-the-box interfaces for operate database
Powerful and flexible where condition wrapper
Multiple strategy to generate primary key
Lambda-style API
Almighty and highly customizable code generator
Automatic paging operation
SQL Inject defense
Support active record
Support pluggable custom interface
Build-in many useful extensions
```

- 参考手册：https://mybatis.plus/guide/

### 6.2.2 SpringBoot与MP集成



# 七.SpringBoot与JPA集成

## 7.1 JPA概述

- JPA的全称：Java Persistence API。Java持久化API
- JPA是SUN公司制定的ORM的规范。
- JPA通过注解描述对象与关系的映射。

## 7.2 JPA优势

- 标准
- 各种容器都支持
- 使用成本较低：相对于EJB（实体Bean）
- 面向对象的查询语言（JPQL）

## 7.3 实现

- Hibernate(JBoss)
- Toplink(Oracle)
- Spring Data JPA

## 7.4 JPA开发入门

```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>5.4.10.Final</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-c3p0 -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-c3p0</artifactId>
    <version>5.4.10.Final</version>
</dependency>
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<persistence xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/persistence"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">

    <persistence-unit name="jpa-demo" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <properties>
            <property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver"/>
            <property name="hibernate.connection.url" value="jdbc:mysql://127.0.0.1:3306/jpa_demo"/>
            <property name="hibernate.connection.username" value="root"/>
            <property name="hibernate.connection.password" value="root"/>
            <!--说明:数据库的方言，用于存放不同数据库之间的SQL语句差异。-->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL57Dialect"/>

            <!--
                create:每次启动服务器重新建表
                update:更新表结构
            -->
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <!--每次执行操作会发SQL语句-->
            <property name="hibernate.show_sql" value="true"/>
            <!--格式化SQL语句-->
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

```java
package com.bjlemon.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jpa_user")
public class User implements Serializable {

    private static final long serialVersionUID = 2173963537830426270L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",length = 4)
    private Integer id;

    @Column(name = "user_name",length = 20,nullable = false)
    private String name;

    @Column(name = "user_password",length = 20,nullable = false)
    private String password;

    @Column(name = "user_salary",length = 6,precision = 2,nullable = false)
    private Float salary;

    @Column(name = "user_birthday",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;
}
```

```java
package com.bjlemon.jpa.util;

import javax.persistence.*;

public class JpaUtils {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("jpa-demo");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager entityManager) {
        if (entityManager != null) {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
```

```java
package com.bjlemon.jpa.test;

import com.bjlemon.jpa.domain.User;
import com.bjlemon.jpa.util.JpaUtils;
import org.hibernate.Hibernate;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void testAdd() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            user = new User();
            user.setName("zhangsan");
            user.setPassword("admin");
            user.setSalary(12.34F);
            user.setBirthday(new Date());

            entityManager.persist(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testDelete() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();


            //            user = entityManager.find(User.class, 2);

            // 查询出来的对象是一个代理对象，延迟加载技术
            // OpenSessionInViewFilter OpenEntityManagerInViewFilter
            user = entityManager.getReference(User.class, 3);
            //            Hibernate.initialize(user);

            entityManager.remove(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testUpdate() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();


            user = entityManager.find(User.class, 4);
            user.setName("aaa");
            user.setPassword("bbb");

            entityManager.merge(user);


            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testFindAll() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();


            List<User> userList = entityManager.createQuery("FROM User").getResultList();
            System.out.println(userList);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testLogin() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();


            user = (User) entityManager.createQuery("FROM User u where u.name = ?1 and u.password = ?2")
                .setParameter(1,"zhangsan")
                .setParameter(2,"admin")
                .getSingleResult();
            System.out.println(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testLogin1() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();


            user = (User) entityManager.createQuery("FROM User u where u.name = :uname and u.password = :pwd")
                .setParameter("uname","zhangsan")
                .setParameter("pwd","admin")
                .getSingleResult();
            System.out.println(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }
}

```

## 7.5 Spring Data JPA

### 7.5.1 Spring Data概述

- Spring Data是一个持久化层大家族。下面有很多的子项目。例如：Spring Data JPA，Spring Data Redis，Spring Data Mongodb，Spring Data Elaticsearch

```markdown
Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store.

It makes it easy to use data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services. This is an umbrella project which contains many subprojects that are specific to a given database. The projects are developed by working together with many of the companies and developers that are behind these exciting technologies.
```

- Spring Data 特点

```markdown
Powerful repository and custom object-mapping abstractions

Dynamic query derivation from repository method names

Implementation domain base classes providing basic properties

Support for transparent auditing (created, last changed)

Possibility to integrate custom repository code

Easy Spring integration via JavaConfig and custom XML namespaces

Advanced integration with Spring MVC controllers

Experimental support for cross-store persistence
```



### 7.5.2 Spring Data JPA

- Spring  Data JPA是JPA规范的另外一套实现。Spring团队针对JPA规范制定的一套实现。

```markdown
1. Spring Data JPA, part of the larger Spring Data family, makes it easy to easily implement JPA based repositories. This module deals with enhanced support for JPA based data access layers. It makes it easier to build Spring-powered applications that use data access technologies.

2. Implementing a data access layer of an application has been cumbersome for quite a while. Too much boilerplate code has to be written to execute simple queries as well as perform pagination, and auditing. Spring Data JPA aims to significantly improve the implementation of data access layers by reducing the effort to the amount that’s actually needed. As a developer you write your repository interfaces, including custom finder methods, and Spring will provide the implementation automatically.
```

- 特点

```
Sophisticated support to build repositories based on Spring and JPA

Support for Querydsl predicates and thus type-safe JPA queries

Transparent auditing of domain class

Pagination support, dynamic query execution, ability to integrate custom data access code

Validation of @Query annotated queries at bootstrap time

Support for XML based entity mapping

JavaConfig based repository configuration by introducing @EnableJpaRepositories.
```



### 7.5.2 Spring Data JPA开发

- Repository接口

![image-20200321204925855](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200321204925855.png) 

- 真正开发中一般使用JpaRepository
- 另外的一种实现方式：使用JpaSpecificationExecutor接口

```java
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {}
```

- 可以直接使用这两个接口中的方法去实现CRUD


![image-20200324200352825](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200324200352825.png) 

![image-20200324200419279](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200324200419279.png) 

- 总结：
  - 可以直接用提供的方法
  - 使用Sprig Data JPA的方法命名方式（规范）：查询方法只能以find或get开头
  - 使用注解@Query
  - 使用Specification的方式来实现

## 7.6 SpringBoot整合Spring Data JPA

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.5.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.bjlemon</groupId>
    <artifactId>springboot-data-jpa-demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot-data-jpa-demo</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.21</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```

```yaml
server:
  port: 8888
spring:
  application:
    name: springboot-data-jpa-demo
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql:///springboot_data_jpa?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: root
    type: com.alibaba.druid.pool.DruidDataSource
    druid:
      initial-size: 5
      max-active: 20
      min-idle: 5
      max-wait: 60000
  jpa:
    generate-ddl: true
    show-sql: true
    open-in-view: true #真正开发中可能有延迟加载，需要将EntityManager延迟关闭
  thymeleaf:
    cache: false
    enabled: true
    encoding: UTF-8
```



# 八.SpringBoot与Spring Security整合

## 8.1 什么是权限管理系统

### 8.1.1 认证

- 登录验证
- 用户进入到系统，必须首先登录。
- 系统会首先根据用户的账号（**用户身份**，用户名称）查询后台
  - 如果查询到了该账户，将该账户的密码（**凭证**）与输入的密码进行匹配
    - 如果匹配成功则认为整个认证通过
    - 如果匹配不成功则认为认证没有通过
  - 如果没有查询到该账户，则认为认证没有通过

### 8.1.2 授权

- 该用户必须首先认证通过
- 系统会对这个用户进行访问控制。实际上就是解决：判断该用户对某资源（菜单、链接、按钮...）能不能访问的问题
- 两种授权方式：
  - 基于角色的访问控制（粗粒度）
  - 基于资源的访问控制（细粒度）



## 8.2 权限管理系统的模型

### 8.2.1 第一种设计

![image-20200324210057779](images/image-20200324210057779.png)



### 8.2.2 第二种设计

 ![image-20200324210118081](images/image-20200324210118081.png)





## 8.3 Spring Security

### 8.3.1 概述

- Spring Security是一个成熟的权限管理解决方案。
- Spring Security是Spring框架的子项目。Spring Security基于Spring开发出来
- Spring Security与Shiro都能完成权限管理系统的开发。而且都是基于Filter来实现，Spring Security在授权的实现上用到了Spring AOP思想
- https://spring.io/projects/spring-security

```markdown
1. Spring Security is a powerful and highly customizable authentication and access-control framework. It is the de-facto standard for securing Spring-based applications.
2. Spring Security is a framework that focuses on providing both authentication and authorization to Java applications. Like all Spring projects, the real power of Spring Security is found in how easily it can be extended to meet custom requirements
```

- 特点

```markdown
1. Comprehensive and extensible support for both Authentication and Authorization
2. Protection against attacks like session fixation, clickjacking, cross site request forgery, etc
3. Servlet API integration
4. Optional integration with Spring Web MVC
5. Much more…
```

- 参考手册：https://docs.spring.io/spring-security/site/docs/5.3.1.BUILD-SNAPSHOT/reference/html5/



### 8.3.2 简单入门

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.bjlemon</groupId>
    <artifactId>springsecurity-demo-1</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
            <version>5.1.5.RELEASE</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-taglibs -->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-taglibs</artifactId>
            <version>5.1.5.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.1.6.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <version>2.3.3</version>
            <scope>provided</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <path>/</path>
                    <port>8080</port>
                    <uriEncoding>UTF-8</uriEncoding>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>

<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath*:applicationContext-security.xml</param-value>
    </context-param>

    <servlet>
        <servlet-name>ssm</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath*:springmvc.xml</param-value>
        </init-param>
    </servlet>

    <servlet-mapping>
        <servlet-name>ssm</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <filter>
        <filter-name>springSecurityFilterChain</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>springSecurityFilterChain</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

</web-app>

```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd">


    <!--
        认证资源的拦截配置
        use-expressions:使用SpringEL表达式
    -->
    <security:http auto-config="true" use-expressions="true">
        <!--
            如果用户拥有'ROLE_USER','ROLE_ADMIN'两个角色中的任意一个即可访问系统
        -->
        <security:intercept-url pattern="/**" access="hasAnyRole('ROLE_USER','ROLE_ADMIN')"/>
    </security:http>

    <!--
        配置用户信息
    -->
    <security:authentication-manager>
        <security:authentication-provider>
            <security:user-service>
                <!--
                    两个账户信息：
                    1. zhangsan:admin:ROLE_ADMIN
                    1. lisi:admin:ROLE_USER
                -->
                <security:user name="zhangsan" authorities="ROLE_ADMIN" password="{noop}admin"/>
                <security:user name="lisi" authorities="ROLE_USER" password="{noop}admin"/>
            </security:user-service>
        </security:authentication-provider>
    </security:authentication-manager>
</beans>
```



### 8.3.3 使用自定义的认证页面

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.bjlemon.security"/>

    <!--
        静态资源配置(放行)
    -->
    <security:http pattern="/js/**" security="none"/>
    <security:http pattern="/images/**" security="none"/>
    <security:http pattern="/css/**" security="none"/>

    <!--
        认证资源的拦截配置
        use-expressions:使用SpringEL表达式
    -->
    <security:http auto-config="true" use-expressions="true">
        <security:intercept-url pattern="/user/login" access="permitAll()"/>
        <security:intercept-url pattern="/error" access="permitAll()"/>

        <security:intercept-url pattern="/**" access="hasAnyRole('ROLE_ADMIN','ROLE_USER')"/>

        <!--
            制定自定义的登录页面
            login-page="/user/login"：进入登录页面的地址
            login-processing-url="/login"：登录的处理的地址。但是此处就写上"/login"。因为此处交给spring security来处理
        -->
        <security:form-login login-page="/user/login"
                             login-processing-url="/login"
                             authentication-success-handler-ref="customAuthenticateSuccessHandler"
                             authentication-failure-handler-ref="customAuthenticateFailureHandler"/>

        <!--
            csrf：跨站请求伪造
        -->
        <security:csrf disabled="true"/>
    </security:http>

    <!--
        配置用户信息
    -->
    <security:authentication-manager>
        <security:authentication-provider>
            <security:user-service>
                <!--
                    两个账户信息：
                    1. zhangsan:admin:ROLE_ADMIN
                    1. lisi:admin:ROLE_USER
                -->
                <security:user name="zhangsan" authorities="ROLE_ADMIN" password="{noop}admin"/>
                <security:user name="lisi" authorities="ROLE_USER" password="{noop}admin"/>
            </security:user-service>
        </security:authentication-provider>
    </security:authentication-manager>
</beans>
```

```java
package com.bjlemon.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticateSuccessHandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        User user = (User) authentication.getPrincipal();
        session.setAttribute("user",user);

        response.sendRedirect(request.getContextPath() + "/index");

    }
}

```

```java
package com.bjlemon.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticateFailureHandler implements AuthenticationFailureHandler {

    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect(request.getContextPath() + "/error");
    }
}
```



### 8.3.4 连接数据库完成认证

```java
package com.bjlemon.security.service.impl;

import com.bjlemon.security.dao.UserDao;
import com.bjlemon.security.domain.Role;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月11日 22:10:00
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        User user = this.userDao.findByName(username);

        if (user == null) {
            return null;
        }

        // TODO 查询该用户所有的权限
        Set<Role> roles = user.getRoles();
        if (!CollectionUtils.isEmpty(roles)) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }

        // 没有加密需要加上"{noop}"
//        return new org.springframework.security.core.userdetails.User(user.getName(), "{noop}" + user.getPassword(), authorities);
//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true, true, true, true, authorities);

    }
}
```

```java
package com.bjlemon.security.dao.impl;

import com.bjlemon.security.dao.UserDao;
import com.bjlemon.security.domain.Role;
import com.bjlemon.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserDaoImpl.java
 * @Description TODO
 * @createTime 2020年02月11日 22:22:00
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByName(String name) {
        User user = null;
        if ("zhangsan".equals(name)) {
            user = new User();
            user.setId(1);
            user.setName(name);
            String password = bCryptPasswordEncoder.encode("admin");
            user.setPassword(password);
            user.setSalary(12.34F);
            user.setBirthday(new Date());

            Set<Role> roles = new HashSet<Role>();
            roles.add(new Role(1, "ROLE_ADMIN"));
            user.setRoles(roles);
        } else if ("lisi".equals(name)) {
            user = new User();
            user.setId(2);
            user.setName(name);
            String password = bCryptPasswordEncoder.encode("admin");
            user.setPassword(password);
            user.setSalary(34.34F);
            user.setBirthday(new Date());

            Set<Role> roles = new HashSet<Role>();
            roles.add(new Role(1, "ROLE_USER"));
            user.setRoles(roles);
        }

        return user;
    }
}

```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.bjlemon.security.service,com.bjlemon.security.handler"/>

    <!--
        静态资源配置(放行)
    -->
    <security:http pattern="/js/**" security="none"/>
    <security:http pattern="/images/**" security="none"/>
    <security:http pattern="/css/**" security="none"/>

    <!--
        认证资源的拦截配置
        use-expressions:使用SpringEL表达式
    -->
    <security:http auto-config="true" use-expressions="true">
        <security:intercept-url pattern="/user/login" access="permitAll()"/>
        <security:intercept-url pattern="/error" access="permitAll()"/>

        <security:intercept-url pattern="/**" access="hasAnyRole('ROLE_ADMIN','ROLE_USER')"/>

        <!--
            制定自定义的登录页面
            login-page="/user/login"：进入登录页面的地址
            login-processing-url="/login"：登录的处理的地址。但是此处就写上"/login"。因为此处交给spring security来处理
        -->
        <security:form-login login-page="/user/login"
                             login-processing-url="/login"
                             authentication-success-handler-ref="customAuthenticateSuccessHandler"
                             authentication-failure-handler-ref="customAuthenticateFailureHandler"/>

        <!--
            csrf：跨站请求伪造
        -->
        <security:csrf disabled="true"/>
    </security:http>

    <!--
        配置用户信息
    -->
    <!--<security:authentication-manager>
        <security:authentication-provider>
            <security:user-service>
                &lt;!&ndash;
                    两个账户信息：
                    1. zhangsan:admin:ROLE_ADMIN
                    1. lisi:admin:ROLE_USER
                &ndash;&gt;
                <security:user name="zhangsan" authorities="ROLE_ADMIN" password="{noop}admin"/>
                <security:user name="lisi" authorities="ROLE_USER" password="{noop}admin"/>
            </security:user-service>
        </security:authentication-provider>
    </security:authentication-manager>-->

    <security:authentication-manager>
        <security:authentication-provider user-service-ref="userService"/>
    </security:authentication-manager>


</beans>
```

- 如果需要使用加密，SpringSecurity使用的是BCryptPasswordEncoder。数据库中的密码字段也需要保存密文，但是用户输入的密码是明文


```xml
<bean id="bCryptPasswordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/>

<security:authentication-manager>
    <security:authentication-provider user-service-ref="userServiceImpl">
        <security:password-encoder ref="bCryptPasswordEncoder"/>
    </security:authentication-provider>
</security:authentication-manager>
```

### 8.3.5 认证实现流程（源码分析）

- 分析UsernamePasswordAuthenticationFilter源码
- UsernamePasswordAuthenticationFilter继承了AbstractAuthenticationProcessingFilter。但是并没有重写doFilter()，因此实际的过滤实现就是在父类上。

![image-20200326205739343](images/image-20200326205739343.png) 

![image-20200326205102793](images/image-20200326205102793.png) 

### 8.3.6 如何显示认证成功的用户信息

```jsp
欢迎${user.username}登录系统!<br>
欢迎<security:authentication property="name"/>登录系统!<br>
欢迎<security:authentication property="principal.username"/>登录系统!<br>
```

### 8.3.7 用户的状态

![image-20200326210213888](images/image-20200326210213888.png) 

- enabled
- accountNonExpired
- credentialsNonExpired
- accountNonLocked

- 认证失败的Handler中就可以根据上述状态来进行细粒度控制失败的异常

```java


/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CustomAuthenticationFailureHandler.java
 * @Description TODO
 * @createTime 2020年02月11日 20:42:00
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        if (exception instanceof DisabledException) {
            session.setAttribute("errorMessage", "账户不可用");
        } else if (exception instanceof AccountExpiredException) {
            session.setAttribute("errorMessage", "账户过期");
        } else if (exception instanceof CredentialsExpiredException) {
            session.setAttribute("errorMessage", "账户凭证过期");
        } else if (exception instanceof LockedException) {
            session.setAttribute("errorMessage", "账户已锁住");
        } else if (exception instanceof InternalAuthenticationServiceException) {
            session.setAttribute("errorMessage", "账户不存在");
        } else if (exception instanceof BadCredentialsException) {
            session.setAttribute("errorMessage", "账户凭证错误");
        }
        response.sendRedirect(request.getContextPath() + "/error");
    }
}
```

### 8.3.8 用户注销

![image-20200326212703849](images/image-20200326212703849.png)  

![image-20200326213800825](images/image-20200326213800825.png) 



### 8.3.9 记住我

![image-20200326214539287](images/image-20200326214539287.png)  



### 8.3.6 授权

- 认证成功后，对资源进行访问控制
- 当前认证成功的用户对系统资源能不能访问的验证
- 实现方式
  - 如果没有权限，则页面上都不要显示菜单或链接（不建议使用）
  - 页面元素显示出来，但是当用户访问某一个资源时，如果该用户没有权限则提示用户
    - 使用注解
- 使用Spring Security标签来实现第一种方式（不要显示菜单或链接 粗粒度）

```jsp
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
```

```jsp
<security:authorize access="hasAnyRole('ROLE_ADMIN')">
    <a href="${pageContext.request.contextPath}/user/add">用户添加</a>
    <a href="${pageContext.request.contextPath}/user/delete">用户删除</a>
    <a href="${pageContext.request.contextPath}/user/edit">用户修改</a>
    <a href="${pageContext.request.contextPath}/user/findAll">用户查询</a>
</security:authorize>

<security:authorize access="hasAnyRole('ROLE_USER')">
    <a href="${pageContext.request.contextPath}/user/findAll">用户查询</a>
</security:authorize>
```

- 使用Spring Security标签来实现第二种方式（注解 细粒度）
  - 注意：打开注解支持
    - 如果注解放在Controller上，对应的注解配置应该放在mvc配置文件中(springmvc.xml)
    - 如果注解放在Service上，对应的注解配置应该放在根容器上（applicationContext-xxx.xml）

```xml
<!--
        jsr250-annotations="enabled"，需要另外导包（jsr250-api）
        pre-post-annotations，支持spring表达式注解
        secured-annotations，spring security提供的注解
    -->
<security:global-method-security jsr250-annotations="enabled" pre-post-annotations="enabled"
                                 secured-annotations="enabled"/>
```

```java
package com.bjlemon.security.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年01月18日 22:37:00
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/list")
    public String list() {
        System.out.println("查询列表");
        return "list";
    }

    @GetMapping("/add")
    @ResponseBody
    @Secured({"ROLE_ADMIN"})
    public String add() {
        System.out.println("add");
        return "success";
    }

    @GetMapping("/delete")
    @ResponseBody
    @Secured({"ROLE_ADMIN"})
    public String delete() {
        System.out.println("delete");
        return "success";
    }

    @GetMapping("/edit")
//    @Secured({"ROLE_ADMIN"})
    @ResponseBody
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public String edit() {
        System.out.println("edit");
        return "success";
    }

    @GetMapping("/findAll")
    @ResponseBody
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String findAll() {
        System.out.println("findAll");
        return "success";
    }

}

```

```java
@ControllerAdvice
public class CustomExceptionHandlerResolver {

    @ExceptionHandler(AccessDeniedException.class)
    public String handleException(HttpSession session) {
        session.setAttribute("errorMessage", "您没有权限！");
        return "redirect:/error";
    }
}
```





## 8.4 SpringBoot与Spring Security整合

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.4.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.bjlemon</groupId>
    <artifactId>springboot-springsecurity-demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot-springsecurity-demo</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-taglibs</artifactId>
            <version>5.2.1.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper-spring-boot-starter -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.13</version>
        </dependency>


        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.21</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.9</version>
        </dependency>

        <dependency>
            <groupId>commons-collections</groupId>
            <artifactId>commons-collections</artifactId>
            <version>3.2.2</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </dependency>

        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```

```yaml
server:
  port: 8888
spring:
  application:
    name: springboot-security-demo
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql:///springboot_security_demo?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: root
    type: com.alibaba.druid.pool.DruidDataSource
    druid:
      initial-size: 5
      max-active: 20
      min-idle: 5
      max-wait: 60000
  mvc:
    view:
      suffix: .jsp
      prefix: /WEB-INF/views/
mybatis:
  mapper-locations: classpath:/mappers/*.xml
  type-aliases-package: com.bjlemon.springboot.domain
  configuration:
    lazy-loading-enabled: true
    aggressive-lazy-loading: false
    cache-enabled: true

```

```java
package com.bjlemon.springboot.config;

import com.bjlemon.springboot.encoder.CustomPasswordEncoder;
import com.bjlemon.springboot.service.UserService;
import com.bjlemon.springboot.web.handler.CustomAuthenticateFailureHandler;
import com.bjlemon.springboot.web.handler.CustomAuthenticateSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/login").permitAll()
            .antMatchers("/error").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/user/login")
            .loginProcessingUrl("/login")
            .successHandler(new CustomAuthenticateSuccessHandler())
            .failureHandler(new CustomAuthenticateFailureHandler())
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/user/login")
            .invalidateHttpSession(true)
            .permitAll()
            .and()
            .csrf()
            .disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(new CustomPasswordEncoder());
    }
}

```

```java
package com.bjlemon.springboot.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年02月15日 21:54:00
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/add")
    @ResponseBody
//    @Secured({"ROLE_ADMIN"})
//    @PreAuthorize(value = "hasAuthority('user:add')")
    @PreAuthorize(value = "hasAuthority('user:add')")
    public String add() {
        System.out.println("add");
        return "success";
    }

    @GetMapping("/delete")
    @ResponseBody
//    @Secured({"ROLE_ADMIN"})
    @PreAuthorize(value = "hasAuthority('user:delete')")
    public String delete() {
        System.out.println("delete");
        return "success";
    }

    @GetMapping("/update")
//    @Secured({"ROLE_ADMIN"})
    @ResponseBody
    @PreAuthorize(value = "hasAuthority('user:update')")
    public String update() {
        System.out.println("update");
        return "success";
    }

    @GetMapping("/findAll")
    @ResponseBody
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
//    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String findAll() {
        System.out.println("findAll");
        return "success";
    }

}

```



# 九.分布式系统认证授权解决方案(扩展)

## 9.1 系统选型

### 9.1.1 基于Session方式

![image-20200331201143364](images/image-20200331201143364.png) 

### 9.1.2 基于Token机制

![image-20200331201737444](images/image-20200331201737444.png) 



## 9.1 概念

- 分布式认证和授权可以理解为就是单点登录
- 单点登录：在分布式系统中用户只需认证一次，在访问其他的系统时就不需要去进行认证。认证服务器和资源服务器
- 认证服务器：认证授权服务器
- 资源服务器：其他的微服务（系统）

![image-20200328213333669](images/image-20200328213333669.png) 

- 传统实现
  - Session共享：一旦认证成功，这台服务器产生Session，但是默认情况下Session不会共享（其他的服务器拿不到这份Session）。解决方案：必须将Session共享，这种架构不容易实现



![image-20200328213745265](images/image-20200328213745265.png) 



- 基于JWT（JSON Web Token）+ RSA（非对称加密算法）

![image-20200328214105174](images/image-20200328214105174.png) 



## 9.2 JWT

- JWT全称：JSON Web Token
- https://jwt.io/
- JWT由三部分组成：
  - Header：
  - Payload：
  - Signature：

```javascript
// javascript
var encodedString = base64UrlEncode(header) + '.' + base64UrlEncode(payload);

var signature = HMACSHA256(encodedString, 'secret'); // TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ
```

```markdown
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ
```

## 9.3 RSA

- RSA是非对称加密算法
- 公钥和私钥

## 9.4 SpringSecurity + JWT + RSA

### 9.4.1 编写认证服务器

```java
package com.bjlemon.security.config;

import com.bjlemon.security.encoder.CustomPasswordEncoder;
import com.bjlemon.security.service.UserService;
import com.bjlemon.security.web.filter.TokenAuthenticateFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName SecurityConfig.java
 * @Description TODO
 * @createTime 2020年02月18日 20:45:00
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private RsaKeyConfig rsaKeyConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilter(new TokenAuthenticateFilter(this.authenticationManager(), this.rsaKeyConfig))
//                .addFilter(new JwtVerifyFilter(this.authenticationManager(), this.rsaKeyConfig))
                .cors()
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(new CustomPasswordEncoder());
    }
}

```

```java
package com.bjlemon.security.web.filter;

import com.bjlemon.security.config.RsaKeyConfig;
import com.bjlemon.security.domain.Role;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.service.RoleService;
import com.bjlemon.security.service.impl.RoleServiceImpl;
import com.bjlemon.security.util.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName TokenAuthenticateFilter.java
 * @Description TODO
 * @createTime 2020年02月20日 21:24:00
 */
public class TokenAuthenticateFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private RsaKeyConfig rsaKeyConfig;

    @Autowired
    private RoleService roleService = new RoleServiceImpl();

    public TokenAuthenticateFilter(AuthenticationManager authenticationManager, RsaKeyConfig rsaKeyConfig) {
        this.authenticationManager = authenticationManager;
        this.rsaKeyConfig = rsaKeyConfig;
    }

    /**
     * @description
     * @author admin
     * @updateTime 2020/2/20 21:25
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
        try {
            ServletInputStream inputStream = request.getInputStream();

            User user = new ObjectMapper().readValue(inputStream, User.class);
            String name = user.getName();
            String password = user.getPassword();
            usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(name, password);
        } catch (Exception e) {
            try {
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter writer = response.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("code", HttpServletResponse.SC_UNAUTHORIZED);
                map.put("message", "账户或密码错误");
                writer.write(new ObjectMapper().writeValueAsString(map));
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    /**
     * @description 认证成功后生成token
     * @author admin
     * @updateTime 2020/2/20 21:34
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = new User();
        String name = authResult.getName();
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();

        user.setName(name);

        // TODO 没实现
        /*List<Role> roleList = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            String roleName = authority.getAuthority();
            Role role = this.roleService.findRoleByName(roleName);
            roleList.add(role);
        }*/

        // 以下代码是测试代码
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("ROLE_API");
        role1.setDescription("ROLE_API");

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("ROLE_USER");
        role2.setDescription("ROLE_USER");

        List<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);
        user.setRoles(roleList);

        // 生成token
        String token = JwtUtils.generateTokenExpireInMinutes(user, this.rsaKeyConfig.getPrivateKey(), 24 * 60);

        // 返回token
        response.addHeader("Authorization", "Bearer " + token);

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpServletResponse.SC_OK);
        map.put("message", "认证成功");
        writer.write(new ObjectMapper().writeValueAsString(map));
        writer.flush();
        writer.close();
    }
}

```

```java
package com.bjlemon.security.config;

import com.bjlemon.security.util.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName RsaKeyConfig.java
 * @Description TODO
 * @createTime 2020年02月20日 21:38:00
 */
@Configuration
@ConfigurationProperties("rsa.key")
public class RsaKeyConfig {

    private String pubKeyFile;
    private String priKeyFile;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    @PostConstruct
    public void createRsaKey() {
        try {
            this.publicKey = RsaUtils.getPublicKey(this.pubKeyFile);
            this.privateKey = RsaUtils.getPrivateKey(this.priKeyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPubKeyFile() {
        return pubKeyFile;
    }

    public void setPubKeyFile(String pubKeyFile) {
        this.pubKeyFile = pubKeyFile;
    }

    public String getPriKeyFile() {
        return priKeyFile;
    }

    public void setPriKeyFile(String priKeyFile) {
        this.priKeyFile = priKeyFile;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}

```

```java
package com.bjlemon.security.util;

public class RsaUtilsTest {

    @org.junit.Test
    public void generateKey() {
        String publicKeyFilename = "F:\\Course Workspace\\bjlemon\\Workspace15\\day15\\code\\springsecurity-jwt-rsa-parent\\key_rsa.pub";
        String privateKeyFilename = "F:\\Course Workspace\\bjlemon\\Workspace15\\day15\\code\\springsecurity-jwt-rsa-parent\\key_rsa";
        try {
            RsaUtils.generateKey(publicKeyFilename, privateKeyFilename, "bjlemon", 2048);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 9.4.2 编写认证服务器

```java
package com.bjlemon.security.config;

import com.bjlemon.security.web.filter.JwtVerifyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName SecurityConfig.java
 * @Description TODO
 * @createTime 2020年02月18日 20:45:00
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private UserService userService;*/

    @Autowired
    private RsaKeyConfig rsaKeyConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilter(new JwtVerifyFilter(this.authenticationManager(), this.rsaKeyConfig))
                // 前后台分离是无状态，不用Session，禁用
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService);
    }*/
}

```

```java
package com.bjlemon.security.config;

import com.bjlemon.security.util.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName RsaKeyConfig.java
 * @Description TODO
 * @createTime 2020年02月20日 21:38:00
 */
@Configuration
@ConfigurationProperties("rsa.key")
public class RsaKeyConfig {

    private String pubKeyFile;
    private String priKeyFile;

    private PublicKey publicKey;
    private PrivateKey privateKey;


    @PostConstruct
    public void loadKey() {
        try {
            this.publicKey = RsaUtils.getPublicKey(this.pubKeyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getPubKeyFile() {
        return pubKeyFile;
    }

    public void setPubKeyFile(String pubKeyFile) {
        this.pubKeyFile = pubKeyFile;
    }

    public String getPriKeyFile() {
        return priKeyFile;
    }

    public void setPriKeyFile(String priKeyFile) {
        this.priKeyFile = priKeyFile;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}

```

```java
package com.bjlemon.security.web.filter;

import com.bjlemon.security.config.RsaKeyConfig;
import com.bjlemon.security.domain.Payload;
import com.bjlemon.security.domain.Role;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.util.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName JwtVerifyFilter.java
 * @Description TODO
 * @createTime 2020年02月20日 21:49:00
 */
public class JwtVerifyFilter extends BasicAuthenticationFilter {

    private RsaKeyConfig rsaKeyConfig;

    public JwtVerifyFilter(AuthenticationManager authenticationManager, RsaKeyConfig rsaKeyConfig) {
        super(authenticationManager);
        this.rsaKeyConfig = rsaKeyConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer")) {
            // 没有认证通过的提示
            // 没有Token,提示用户重新认证
            try {
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                PrintWriter writer = response.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("code", HttpServletResponse.SC_FORBIDDEN);
                map.put("message", " 没有Token,请重新认证");
                writer.write(new ObjectMapper().writeValueAsString(map));
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            // 校验
            String token = header.replace("Bearer ", "");
            Payload<User> payload = JwtUtils.getInfoFromToken(token, rsaKeyConfig.getPublicKey(), User.class);
            User user = payload.getUserInfo();
            if (user != null) {

                List<Role> roleList = user.getRoles();

                for (Role role : roleList) {
                    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
                    simpleGrantedAuthorities.add(simpleGrantedAuthority);
                }


                UsernamePasswordAuthenticationToken authenticateResult = new UsernamePasswordAuthenticationToken(
                        user.getName(),
                        user.getPassword(), simpleGrantedAuthorities);
                SecurityContextHolder.getContext().setAuthentication(authenticateResult);
                chain.doFilter(request, response);
            }
        }

    }
}

```



## 9.5 Spring Cloud OAuth2认证和授权（自学）

![image-20200331222929493](images/image-20200331222929493.png) 



### 9.5.1 OAuth2

- 为用户资源的授权提供了一种安全开放的标准
- 系统之间的一种认证授权机制
- 用于第三方的认证授权

### 9.5.2 应用场景

- 举例：

![image-20200331223807689](images/image-20200331223807689.png) 



### 9.5.3 OAuth2授权模式

- 授权码模式
- 简化模式
- 密码模式
- 客户端模式

### 9.5.4 授权码模式

![image-20200331225141418](images/image-20200331225141418.png)

![image-20200502111327119](C:\Users\夜神\AppData\Roaming\Typora\typora-user-images\image-20200502111327119.png)

可以结合JWT，JWT的token比OAtho2默认的token安全性高





### 9.5.5 实战

- 建立数据库和表
- https://github.com/spring-projects/spring-security-oauth

```sql
-- used in tests that use HSQL
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);

create table oauth_code (
  code VARCHAR(256), authentication LONGVARBINARY
);

create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);


-- customized oauth_client_details table
create table ClientDetails (
  appId VARCHAR(256) PRIMARY KEY,
  resourceIds VARCHAR(256),
  appSecret VARCHAR(256),
  scope VARCHAR(256),
  grantTypes VARCHAR(256),
  redirectUrl VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(256)
);

```

- 授权服务器配置

```java
package com.bjlemon.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class OauthAuthoricationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(this.dataSource);
    }

    @Bean
    public ApprovalStore approvalStore() {
        return new JdbcApprovalStore(this.dataSource);
    }

    @Bean
    public ClientDetailsService clientDetailsService() {
        return new JdbcClientDetailsService(this.dataSource);
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(this.dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单方式提交数据
        security.allowFormAuthenticationForClients();

        // 允许检测Token
        security.checkTokenAccess("permitAll()");
        security.tokenKeyAccess("permitAll()");
    }

    /**
     * 指定客户端信息的数据来源
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(this.clientDetailsService());
    }

    /**
     * Oauth2s所有配置的汇总
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(this.tokenStore())
                .approvalStore(this.approvalStore())
                .authorizationCodeServices(this.authorizationCodeServices())
                .authenticationManager(this.authenticationManager);
    }
}
```

```java
package com.bjlemon.oauth.config;

import com.bjlemon.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(this.bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .csrf()
                .disable();
    }
}

```

- 资源服务器配置

```java
package com.bjlemon.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableResourceServer
public class OauthResourceConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(this.dataSource);
    }

    /**
     * 指定当前资源的id和存储方案
     *
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("product_api").tokenStore(this.tokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //指定不同请求方式访问资源所需要的权限，一般查询是read，其余是write。
                .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('write')")
                .and()
                .headers().addHeaderWriter((request, response) -> {
            response.addHeader("Access-Control-Allow-Origin", "*");//允许跨域
            if (request.getMethod().equals("OPTIONS")) {//如果是跨域的预检请求，则原封不动向下传达请求头信息
                response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Request-Method"));
                response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
            }
        });
    }
}
```





```markdown
http://localhost:9999/oauth/authorize?response_type=code&client_id=dongnao_1
```













# 十.自动配置原理

## 10.1 分析入口

- @SpringBootApplication

![image-20200402214645900](images/image-20200402214645900.png) 

- @SpringBootConfiguration
  - 自身就是一个配置类，意味着@SpringBootApplication注解也就是一个配置类（配置文件）

- @EnableAutoConfiguration
  - @AutoConfigurationPackage
  - @Import(AutoConfigurationImportSelector.class)

![image-20200402220410259](images/image-20200402220410259.png) 

- 扫描所有的jar包类路径下META-INF/spring.factories，把这些文件中的内容包装成Properites对象，然后将org.springframework.boot.autoconfigure.EnableAutoConfiguration键对应的值所代表的类纳入Spring容器中

- 以ActiveMQAutoConfiguration为例讲解

  ```java
  @Configuration(proxyBeanMethods = false)
  @AutoConfigureBefore(JmsAutoConfiguration.class)
  @AutoConfigureAfter({ JndiConnectionFactoryAutoConfiguration.class })
  @ConditionalOnClass({ ConnectionFactory.class, ActiveMQConnectionFactory.class })
  @ConditionalOnMissingBean(ConnectionFactory.class)
  @EnableConfigurationProperties({ ActiveMQProperties.class, JmsProperties.class })
  @Import({ ActiveMQXAConnectionFactoryConfiguration.class, ActiveMQConnectionFactoryConfiguration.class })
  public class ActiveMQAutoConfiguration {
  
  }
  ```

- @ConditionalOnClass({ ConnectionFactory.class, ActiveMQConnectionFactory.class })：当项目中有ConnectionFactory.class, ActiveMQConnectionFactory.class，ActiveMQAutoConfiguration配置类才生效
-  总结：
  - SpringBoot会加载大量的自动配置类
  - 程序员首先判断SpringBoot有没有写好这个自动配置类，如果写好了我们就不用自己配置了
  -  我们也可以进行配置的修改，修改application.properties即可      

- SpringApplication类源码分析
  - ApplicationContextInitializer
  - SpringApplicationRunListener

![image-20200402224545606](images/image-20200402224545606.png) 

![img](images/SNAGHTMLbed2ad.PNG)















# 十一.自定义Starter











































































































































































