package servlet_02;

import java.io.FileInputStream;
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
 * Servlet implementation class TestServlet04
 */
@WebServlet("/TestServlet10")
public class TestServlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  //获取请求的参数的文件的名称
	String fileName=	request.getParameter("fileName");
    //使用流将文件加载到内存中
	    //获取ServletContext对象，用于找打文件的服务器的路径地址
	ServletContext  servletContext=  this.getServletContext();
	String  realPath=servletContext.getRealPath("/img/"+fileName);
	   //使用字节流进关联
	FileInputStream  fis=new FileInputStream(realPath);
	   //3.设置响应头信息
  String  mimeType=	servletContext.getMimeType("MIME:"+fileName);
	response.setHeader("Content-Type", mimeType);
	  //设置响应打开的方式
	    //获取请求的User-Agent的数据信息
  String  agent=	request.getHeader("User-Agent");
       //  使用工具列进行编码文件名称
           
		/*
		 * 下节课接着讲
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

