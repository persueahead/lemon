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
 * 验证重定向时，资源是否共享，地址是否改变
 * Servlet implementation class TestServlet04
 */
@WebServlet("/TestServlet7")
public class TestServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 System.out.println("TestServlet7------------");

//	 会话
	 HttpSession  session= request.getSession();
//	 获取属性值，该方法返回的是object对象
	 //可以获取到，重定向下， Session域数据可以资源共享
		String  strsession= (String) session.getAttribute("amdinSession");
		System.out.println("======strsession======"+strsession);
//		获取不到，通过重定向跳转，Request域的资源不共享
	String  str= (String) request.getAttribute("amdin");
		System.out.println("============"+str);
	 
		
		response.sendRedirect("https://www.baidu.com/");
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

