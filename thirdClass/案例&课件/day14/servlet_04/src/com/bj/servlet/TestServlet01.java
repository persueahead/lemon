package com.bj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

/**
 * Servlet implementation class TestServlet01
 */
@WebServlet("/TestServlet01")
public class TestServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               
		HttpSession  session=	request.getSession();
		session.setAttribute("msg", "1qweqweqweqw");
		
		/* Object obj= session.getAttribute("msg"); 
		   System.out.println(obj);*/
		/*
		 * session.getId()返回该会话的标识符字符串JSESSIONID 的 ID号
		 * 设置时键的值为JSESIONID
		 * //创建Cookie Cookie cook= new Cookie("JSESSIONID",session.getId());
		 * 接收ID后设置保存时间，这样，关闭客户端后次请求的ID就是一样的
		 * //设置Cookie的时间 cook.setMaxAge(60 * 60);
		 * 
		 * response.addCookie(cook);
		 */
		 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
