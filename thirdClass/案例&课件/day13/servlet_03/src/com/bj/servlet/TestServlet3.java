package com.bj.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//cookie值的获取
@WebServlet("/TestServlet03")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//获取Cookie值
		/* getCookies()
		 * 返回一个数组，其中包含客户端随此请求发送的所有Cookieobjects。 
		 * 如果没有发送cookie，此方法将返回null。
		 */
		Cookie[]  cook=request.getCookies();
         
		 for (Cookie cookie : cook) {
//			 为这个Cookie分配一个新值。
	       cookie.setValue("newvalue");
			/*
			 * 创建后不能更改名称。
			 *  返回cookie的名称。getName() 
			 *  返回cookie的值getValue()
			 */
	       System.out.println( cookie.getName()+":"+cookie.getValue());

	       
//	       javax.servlet.http.Cookie@7af95df7
	       System.out.println( cookie);
		 }
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
