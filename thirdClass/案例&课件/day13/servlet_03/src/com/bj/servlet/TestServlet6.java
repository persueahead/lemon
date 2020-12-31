package com.bj.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*处理中文
编码*/
@WebServlet("/TestServlet06")
public class TestServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet6() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理乱码,将中文处理成utf-8
		/*重写此请求主体中使用的字符编码的名称。
		必须在使用getReader()读取请求参数或读取输入之前调用此方法。
		否则，它没有任何效果。*/
	 	  //处理乱码
				response.setCharacterEncoding("UTF-8");
				Cookie  cook=	new Cookie("name",URLDecoder.decode( "小张","UTF-8"));
				response.addCookie(cook);
		
		/*response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");

		Cookie[] c = request.getCookies();
		if (c != null) {
			for (Cookie cookie : c) {
				System.out.println(cookie.getName() + "===>" + URLDecoder.decode(cookie.getValue(), "UTF-8"));
			}
		}
//设置响应中		中文乱码处理	URLEncoder.encode
		Cookie cookie1 = new Cookie("name1", URLEncoder.encode("测试", "UTF-8"));
		//Cookie cookie1 = new Cookie("name1", "测试");
		response.addCookie(cookie1);*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
