package com.bj.homework;

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

/**
 * Servlet implementation class DocumentDownload
 */
@WebServlet("/DocumentDownload")
public class DocumentDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取文件名
		String wordDocument=request.getParameter("wordDocument");
		/*创建用于整个web项目内部通信的对象
		 * ServletContext,
		定义servlet用于与其servlet容器通信的一组方法，
		例如，获取文件的MIME类型、dispatchrequests或写入日志文件。*/
		ServletContext servletContext=	this.getServletContext();
		//获取被下载文件的实际路径
		String realPath=	servletContext.getRealPath("/img/"+wordDocument);
		//创建读取io流
		FileInputStream file=   new FileInputStream(realPath);
		/**
		 * 设置响应头，告诉浏览器返回内容的基本信息
		 */
		//获取文件MIME类型
		String mimeType=servletContext.getMimeType(wordDocument);
		//设置content-type
		response.setHeader("content-type", mimeType);
		//处理中文乱码
		wordDocument= URLEncoder.encode(wordDocument,"UTF-8");
		//设置扩展头，以下载框的形式打开文件
		response.setHeader("content-disposition", "attachment;filename="+wordDocument);
		//获取向客户机输出的输出流
		ServletOutputStream  so=	response.getOutputStream();     
	    //创建缓存数组
		byte[]  buff=    new  byte[1024*1024];
	    //接收一次读取的数据大小
		int  len=0;
	    //边读边写
		//read,每次读取数组长度的字节
	    while((len=file.read(buff))!=-1) {
	    	//每次写入len字节内容
	    	so.write(buff,0,len);
	    }
	    //关闭io流
	    file.close();	
	    so.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
