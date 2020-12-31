package com.bj.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class TestFilter
 */

@WebFilter("/*")
public class TestFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		   
		//进行判断Session是否有数据
		HttpServletRequest  httpRequest=(HttpServletRequest)request;
		HttpServletResponse  httpResponse=(HttpServletResponse)response;
	String name=(String)httpRequest.getSession().getAttribute("name");
	String pwd=	(String)httpRequest.getSession().getAttribute("pwd");
	String  url=httpRequest.getRequestURI();
	  if(name !=null  && pwd !=null) {
	 chain.doFilter(request, response);
	  }else if(url.contains("TestLongServlet")) {
		 chain.doFilter(request, response);
	  }else if(url.contains("TestImgServlet")) {
			 chain.doFilter(request, response);
	  }else {
			  System.out.println("@WebFilter:  httpRequest.getRequestDispatcher(\"list.jsp\").forward(request, response); ");
			httpRequest.getRequestDispatcher("/list.jsp").forward(request, response); 
		}
	  }
	
		
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
