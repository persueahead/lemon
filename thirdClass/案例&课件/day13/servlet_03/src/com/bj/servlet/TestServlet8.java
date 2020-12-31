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
/**
 * 
 * @author ztw
 *cookie资源共享
 */
@WebServlet("/TestServlet08")
public class TestServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //设置Cookie'
		Cookie  cooke=  new Cookie("name","admin");
//		同一服务器，不同工程下，加上cooke.setPath("/")可以实现cookie共享
		cooke.setPath("/");
		/*不同服务器中
		 * cooke.setDomain(domain);
		指定应在其中显示此cookie的域。
		域名的形式由RFC 2109指定。
		domainname以一个点(.foo.com)开头，
			表示cookie对位于指定域名系统(DNS)区域的服务器可见
				(例如，www.foo.com，但不包括a.b.f e.com)。
					默认情况下，cookie只返回给发送它们的服务器。*/
		response.addCookie(cooke);
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
