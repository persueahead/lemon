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
 * 利用Io流向浏览器输送数据
 * Servlet implementation class TestServlet04
 */
@WebServlet("/TestServlet8")
public class TestServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 System.out.println("TestServlet8------------");
//	 响应头，设置具体请求中的媒体类型信息
//	 	设置字符集处理中文乱码
	 response.setHeader("Content-Type","text/html;charset=UTF-8");
//	or这个方法 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter  pt=	 response.getWriter();
//	 把后台的数据向前台输出
	     pt.write("我隔壁老陈");
	 
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

