package com.bj.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*处理中文
解码*/
@WebServlet("/TestServlet07")
public class TestServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //获取Cookie'
		Cookie[]  cs=	request.getCookies();
		if(cs!=null) {
			for (Cookie cookie : cs) {
			String  name=	cookie.getName();
			String value=	cookie.getValue();
				//System.out.println(name+":"+value);
				System.out.println(name+":"+URLDecoder.decode(value,"UTF-8"));
			}
		}
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
