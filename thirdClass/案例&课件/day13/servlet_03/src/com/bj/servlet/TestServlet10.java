package com.bj.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * session	服务端会话	关键类	HttpSession 
 * 提供一种方法来跨多个pagerequest标识用户或访问Web站点，
 * 并存储关于该用户的信息。
 * 会话在用户发出的多个连接或页面请求之间持续指定的时间。
 * 一个会话通常对应一个用户，该用户可能多次访问一个站点。
 * @author ztw
 *
 */
@WebServlet("/TestServlet10")
public class TestServlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			/**
			 * 获取Session对象步骤
			 * 	  request.getSession()请求并创建session
			 * 		session.setAttribute(String name, Object value)设置session内容
			 */
		HttpSession session=	request.getSession();
		session.setAttribute("seesion","admin");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
