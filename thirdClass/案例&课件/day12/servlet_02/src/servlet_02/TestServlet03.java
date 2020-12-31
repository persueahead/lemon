package servlet_02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 了解Request的相关功能
 * api： http://tomcat.apache.org/tomcat-5.5-doc/servletapi/
 * Servlet implementation class TestServlet03
 */
@WebServlet("/TestServlet03")
public class TestServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		常用方法
		System.out.println("**request.getMethod():"+request.getMethod());
		System.out.println("**获取虚拟的目录地址:"+request.getContextPath());
		System.out.println("**获取Servlet的路径地址:"+request.getServletPath());
//		自动带上参数名
		System.out.println("获取请求的参数:"+request.getQueryString());
//		不带参数名
		System.out.println("**获取请求的参数name:"+request.getParameter("name"));
		System.out.println("**获取请求的URL的地址:"+request.getRequestURI());
		System.out.println("获取请求的HTTP的版本:"+request.getProtocol());
		System.out.println("获取请求的IP地址:"+request.getRemoteAddr());
		System.out.println("获取请求头的数据:"+request.getHeaderNames());
		/* request.getHeaderNames(); */
		
		
		
		System.out.println(	"-doGet---");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(	"--doPost--");
	}

}
