package servlet_02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 转发
 * 资源共享
 * Servlet implementation class TestServlet04
 */
@WebServlet("/TestServlet05")
public class TestServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 System.out.println("TestServlet05------------");
	
		/* 获取04中设置的属性的值 */
	String  str= (String) request.getAttribute("admin");
	System.out.println(str);
	

	
	//获取值后转发到  页面
	 request.getRequestDispatcher("index2.jsp").forward(request, response);
	 

	 
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
