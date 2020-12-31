package servlet_02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * request获取客户端请求的服务器的相关信息
 * response像浏览器输出
 *  ServletContext 作用域为全局
 * Servlet implementation class TestServlet04
 */
@WebServlet("/TestServlet9")
public class TestServlet9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* System.out.println("TestServlet8------------"); */
	 response.setHeader("Content-Type","text/html;charset=UTF-8");
	
//	 范围是全局
	 ServletContext  context=	 request.getServletContext();
	 System.out.println(context.getMimeType("D:\\document\\柠檬2\\三阶段\\案例&课件\\day12\\servlet_02\\WebContent\\index.jsp"));
	 System.out.println("--------------");
	 System.out.println(context.getRealPath("/index.jsp"));
	 System.out.println("--------------");
	 System.out.println(context.getRealPath("/WEB-INF/web.xml"));
	
	 
	 PrintWriter  pt=	 response.getWriter();
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

