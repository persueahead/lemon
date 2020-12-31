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
			//设置字符集编码
		request.setCharacterEncoding("utf-8");
		//获取参数
		String  userName=request.getParameter("userName"); 
		String  userPwd=request.getParameter("userPwd"); 
		String  checkCode=request.getParameter("checkCode"); 
		//3.获取已经生成好验证码
	    String checkCode_session=	(String) request.getSession().getAttribute("checkCode_session"); 
		  //进行删除Session中的数据
	    request.getSession().removeAttribute("checkCode_session");
	
	     //进行判断验证码
	      /**
	       * 扩展：
	       *    有的验证码是不进行区分大小写，
	       *     那么就进行在会后把验证码(获取和后台生成的验证码)统一的进行转换为大写或者是小写
	       *     这样无论用户输入的大写还是小写，那么都可以进行验证 了
	       * 
	       * 
	       */
	     if(checkCode !=null && checkCode_session.equalsIgnoreCase(checkCode)) {
	    
	    
	    //进行判断用户名和密码是否ok
	       if("admin".equals(userName) && "admin".equals(userPwd)){

	    	   //如果用户名和密码是之前的,那么就进行调用Serivce中的数据
	    	   
	    	   //如果账号密码是正确，那么就进行存入到Seesion
	    	   request.getSession().setAttribute("name","admin");
	    	   request.getSession().setAttribute("pwd", "admin");
	    	   
	    	   //进行提示用户是否登陆了了，并返回数据
	    	   request.setAttribute("message", "亲欢迎你登陆到当前的系统");
	    	   //进行跳转到首页
	    	   
	    	   //转发
	    	   //重定向
	    	 //  我们进行重定向
	    	   //response.sendRedirect("");
	    	   request.getRequestDispatcher("index.jsp").forward(request, response);
	    	   
	       }else {
	    	   //如果用户名和密码不正确的情况下
	    	    //就进行返回到登陆页面
	    	   request.setAttribute("message", "账号和密出现错误，还请重新输入");
	    	   request.getRequestDispatcher("list.jsp").forward(request, response);
	       }
	    	
	     }else {
	    	 //如果用验证码不正确，那么进行执行这里的编码
	    	   request.setAttribute("message", "验证码不正确，还请求重新输入");
	    	   request.getRequestDispatcher("list.jsp").forward(request, response);
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
