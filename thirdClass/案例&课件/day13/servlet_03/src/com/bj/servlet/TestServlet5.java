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

/*
 * 设置cookie在浏览器中保存的时间
 * 默认	浏览器关闭后cookie数据销毁
 * 正数(指定秒)	Cookie进行持久化到硬盘中，n 秒之后会进行自动的删除Cookie文件
*/
@WebServlet("/TestServlet05")
public class TestServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie  cook1=	  new Cookie("phone","1234567890");
		//测试Cookie的时间
		//在30之内，Cookie进行持久化到硬盘中，30之后会进行自动的删除Cookie文件
		cook1.setMaxAge(30);//30秒
//		cook1.setMaxAge(-1);//默认
	//	cook1.setMaxAge(0);//删除
		response.addCookie(cook1);
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
