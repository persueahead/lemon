package com.bj.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 记录访问时间
 * 	设置cookie保存时间
 * 		判断是否第一次登陆
 * @author ztw
 *
 */
@WebServlet("/TestServlet09")
public class TestServlet9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//设置消息头以及编码的格式
		response.setContentType("text/html;charset=UTF-8");
		   //1.获取Cookie值
		Cookie []  cookies=request.getCookies();
		  boolean boo=false;
		  
		      //2.进行遍历cookies
		  /**
		   * 当不是一次访问的时候
		   */
		  if(cookies!=null && cookies.length>0) {
			  
			  for (Cookie cookie : cookies) {
				//3.获取Cookie中的名称
				String name=  cookie.getName(); 
			        //进行判断是否在cookie存在了某个cookie的name：【lastDate】
			    	if("lastDate".equals(name)) {
			    		//如存在cookie  。那么就不是第一访问的
			    		boo=true;
			    		//设置Cookie的value
			    		  //获取时间
			    		Date  date=new Date();
			    		  //格式化时间
			    		SimpleDateFormat  sdf=  new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			    		String string_date=sdf.format(date);
			    		//转码
			    		string_date=URLEncoder.encode(string_date,"utf-8");
			    	
			    	
			    		
			    		//获取Cookie中value
			    	String value=	cookie.getValue();
			    		
			    		//解码并重新赋值，赋予当前登陆时间
			     	value=	URLDecoder.decode(value,"utf-8");
			     	
				    	//设置第二次访问的时间
			    		cookie.setValue(string_date);
			    		//设置cookie存活的时间
			    		cookie.setMaxAge(60*60*24*30);
			    	  //返回Cookie
		    		    response.addCookie(cookie);
			    		response.getWriter().write("<H4>亲，上次访问等的时间"+value+"</H4>");
			    	}
			  
			  }
		  }
		  
		  /**
		   * 当第一次访问的时候
		   * */
		  if(cookies==null  || cookies.length== 0 || boo==false) {
			    //设置Cookie中values
			       //获取时间
			  Date  date=  new Date();
			  //格式化时间
	    		SimpleDateFormat  sdf=  new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	    		String string_date=sdf.format(date);
	    		//转码
	    		string_date=URLEncoder.encode(string_date, "utf-8");
	    		 //创建Cookie
	    		Cookie  cook=new Cookie("lastDate",string_date);
	    		//设置cookie存活的时间
	    		cook.setMaxAge(60*60*24*30);
	    		//返回Cookie
	    		response.addCookie(cook);
	    		  /*返回到页面
	    		response.getWriter()
	    		返回一个PrintWriter对象，
	    		该对象可以向客户机发送字符文本。PrintWriter使用getCharacterEncoding返回的字符编码。*/
	    		response.getWriter().write("<H4>亲，欢迎第一次登陆这里</H4>");	
		  
		  }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
