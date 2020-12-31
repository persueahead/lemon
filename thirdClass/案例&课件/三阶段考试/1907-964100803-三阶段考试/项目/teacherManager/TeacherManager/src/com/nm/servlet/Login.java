package com.nm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nm.dao.Manager;
import com.nm.model.Teacher;
import com.nm.model.User;
import com.nm.util.Quary;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//初始化
		try {
			Quary.selectAll();
			Manager.quary();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//---------------------------------------------------------
		 ServletContext context=request.getServletContext();
		/*
		 * ArrayList<User> mana=null;
		 *  mana=Manager.getManagerList();
		 */
		 //验证账号密码
		HashMap managerMap=null;
		managerMap=Manager.getMap();
		 String name=request.getParameter("username");
		  String password=request.getParameter("password");
		 
		  int pag=1;
		  //判断账号密码是否正确，不正确则跳回登陆页面		  
		 //传入管理员名字
		  //设置用户名为全局属性,让head.jsp抓取
		  context.setAttribute("username", name);
		  //设置密码为全局属性
		  context.setAttribute("password", password);
		  //教师职工信息
		  ArrayList<Teacher> teacher=Quary.getList();
		     int length=Quary.getLength();
		      context.setAttribute("teachers", teacher);
			   context.setAttribute("listLength", length);
			   boolean flag=password.equals(managerMap.get(name));
		  if(flag) {
		  response.sendRedirect("main.jsp");
		 //获取教职工信息，将数据库数据传入web域，数据库信息能够被共享
		   	       
			   
	 }else {				
		 if(pag==1) {
		 context.setAttribute("reback", pag);
		 response.sendRedirect("login.jsp");
		 pag=2;
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
