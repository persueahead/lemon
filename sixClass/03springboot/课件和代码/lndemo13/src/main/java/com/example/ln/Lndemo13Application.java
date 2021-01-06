package com.example.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.ln.filter.MyFilter;
import com.example.ln.listener.MyListener;
import com.example.ln.servlet.MyServlet1;
import com.example.ln.servlet.MyServlet2;

/**
 * 这类 作为配置文件
 * @author Administrator
 *
 */
@SpringBootApplication
public class Lndemo13Application {

	public static void main(String[] args) {
		SpringApplication.run(Lndemo13Application.class, args);
	}
	
	/**
	 * 集成或配置Servlet 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServlet() {
		return new ServletRegistrationBean(new MyServlet1(),"/my1");
	}
	
	@Bean
	public ServletRegistrationBean getServlet2() {
		return new ServletRegistrationBean(new MyServlet2(),"/my2");
	}
	
	/**
	 * 配置过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getFilter() {
		return new FilterRegistrationBean(new MyFilter(),getServlet(),getServlet2());
	}
	
	/**
	 * 配置监听器
	 */
	@Bean
	public ServletListenerRegistrationBean<MyListener> getListener() {
		return new ServletListenerRegistrationBean<>(new MyListener());
	}
}
