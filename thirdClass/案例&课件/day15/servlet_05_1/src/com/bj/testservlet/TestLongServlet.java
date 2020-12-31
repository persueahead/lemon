package com.bj.testservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestLongServlet
 */
@WebServlet("/TestLongServlet")
public class TestLongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestLongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	  
		
		//获取数据
	String userName= 	request.getParameter("userName");
	String userPwd= 	request.getParameter("userPwd");
	String checkCode= 	request.getParameter("checkCode");		
	   //获取session中的验证码
	
	String checkCode_session=  (String) request.getSession().getAttribute("checkCode_session");
	    //一定要进行删除
	 request.getSession().removeAttribute("checkCode_session");	
	
	 
	    //进行判断验证码是否正确
	    if(checkCode_session!=null  && checkCode_session.equalsIgnoreCase(checkCode)) {
	    	 //密码和用户是不是正确的
	    	   if("admin".equals(userName)  && "admin".equals(userPwd)) {
	    		   //密正确，调用方法进行查询数据库的数据
	    		   
	    		   
	    		   
	    	   }
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	 
	 
	 
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
