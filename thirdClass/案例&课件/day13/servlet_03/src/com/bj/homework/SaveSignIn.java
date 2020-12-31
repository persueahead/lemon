package com.bj.homework;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveSignIn
 */
@WebServlet("/SaveSignIn")
public class SaveSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveSignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//通过表单提交，且method=post，http请求方法为post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		Cookie []  cookies=request.getCookies();				  	
		    //设置Cookie中values
		   String usename=request.getParameter("username");
    		 //创建Cookie
    		Cookie  user=new Cookie("username",usename);
    		String pass=request.getParameter("password");
    		Cookie password=new Cookie("password",pass);
    		
    		//设置cookie存活的时间
    		user.setMaxAge(60*60*24*30);
    		password.setMaxAge(60*60*24*30);
    		//返回Cookie
    		response.addCookie(user);
    		response.addCookie(password);   
    		System.out.println(request.getParameter("name"));
	}
}
