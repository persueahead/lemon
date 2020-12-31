package servlet_02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1-3、转发
			     在服务器内部的资源中进行跳转
			      特点:
				    1.浏览器的地址不会发生改变
				    2.只能进行转发到当前的服务器内部资源中
				    3.转发是一次请求 	 	
 * 
 * 
 * Servlet implementation class TestServlet04
 */
@WebServlet("/TestServlet04")
public class TestServlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 System.out.println("TestServlet04------------");
	
	 //设置属性，键值对的形式
	 request.setAttribute("admin","adminMessgae");
	 
		/*
		 * 转发 
		 *	转发到Servlet的请求路径地址TestServlet04 
		 * 		转发到TestServlet05
		 */
	 request.getRequestDispatcher("/TestServlet05").forward(request, response);

	   
	 
	 
	 
	 
	 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
