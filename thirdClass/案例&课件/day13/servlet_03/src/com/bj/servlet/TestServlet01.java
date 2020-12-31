package com.bj.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//文件下载文件
@WebServlet("/TestServlet01")
public class TestServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   /**
	    * 文件下载
	    * 先获取文件的路径地址
	    * 	使用字节流关联地址
	    * 		设置响应头
	    * 			读取并向客户端输出
	    * 			
	    */
		//以字符串的形式返回请求参数的值，否则返回null
	   //获取请求的参数,要下载的文件名(19年7月24日后Java全栈工程师大纲.xlsx,在index.jsp中设置的)
		String fileName=request.getParameter("filename");
		System.out.println(fileName);
		/**
		 * 使用字节流中的输入流加载文件到内存中
		 */		
		 //2找到文件服务器路径		
		/*
		 * 返回对运行此servletis的ServletContext的引用。(servlet容器的引用)
		 *  整个web项目应用，作用全局
		 */
		ServletContext servletContext=	this.getServletContext();
		//org.apache.catalina.core.ApplicationContextFacade@4c1f544e
		System.out.println(servletContext);
		/*
		 * 获取与给定虚拟路径对应的实路径。
		 *  通过容器对象找到与给定虚拟路径相对应的实际路径地址
		 */
		String realPath=	servletContext.getRealPath("/img/"+fileName);
		/*
		 * G:\eclipse\workpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\
		 * wtpwebapps\day03-servlet03\img\19年7月24日后Java全栈工程师大纲.xlsx
		 */
		System.out.println(realPath); 
		
	//通过指定路径字符串，创建字节输入流对象
	FileInputStream file=   new FileInputStream(realPath);
	      /**
	       * 设置响应头的消息	
	       */
		   //设置响应头类型
	//返回指定文件的MIME类型，如果MIME类型未知，则返回null。
	String mimeType=servletContext.getMimeType(fileName);
		/*
		 * application/vnd.openxmlformats-officedocument.spreadsheetml.sheet 
		 * 该后缀表示一种工作表
		 */
	System.out.println("媒体文件类型："+mimeType);
	
	
		/*
		 * 设置响应头
		 *  content-type：表示后面的文档属于什么MIME类型
		 */
	response.setHeader("content-type", mimeType);
	   /**
	    * 进行设置响应头打开的方式
	    */
		//由于中文会出现乱码的问题，先进行格式化
	fileName= URLEncoder.encode(fileName,"UTF-8");
	   //设置响应头打开的方式
	response.setHeader("content-disposition", "attachment;filename="+fileName);
	  //将输入的数据写出到输出流中，该类提供一个输出流，用于向客户发送二进制数据
    ServletOutputStream  so=	response.getOutputStream();     
    byte[]  buff=    new  byte[1024*1024];
    int  len=0;
    //边读边写
    while((len=file.read(buff))!=-1) {
    	so.write(buff,0,len);
    }
    file.close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
