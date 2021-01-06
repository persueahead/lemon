package com.example.ln;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import com.example.ln.filter.MyFilter;
import com.example.ln.listener.MyListener;
import com.example.ln.servlet.MyServlet1;
import com.example.ln.servlet.MyServlet2;

/**
 * 这类 作为配置文件
 * 
 * @author Administrator
 *
 */
@SpringBootApplication
public class Lndemo13Application implements ServletContextInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Lndemo13Application.class, args);
	}

	@Override
	public void onStartup(ServletContext cervletContext) throws ServletException {
		//注册servlet
		cervletContext.addServlet("m1", MyServlet1.class).addMapping("/mm1");
		cervletContext.addServlet("m2", MyServlet2.class).addMapping("/mm2");
		//注册监听器
		cervletContext.addListener(MyListener.class);
		
		//过滤器
		cervletContext.addFilter("f1", MyFilter.class).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
	}

}
