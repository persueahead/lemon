package servlet_02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 重定向
 * 响应
 * Servlet implementation class TestServlet04
 */
@WebServlet("/TestServlet6")
public class TestServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 System.out.println("TestServlet6------------");
	
//	 设置属性，键值对形式
	 request.setAttribute("amdin","adminMssage");
//	 会话（服务端）
	 HttpSession  session= request.getSession();
//	 Session域数据
	 session.setAttribute("amdinSession", "amdinSessionMssage");
	 
//重定向
	 response.sendRedirect("TestServlet7");
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
