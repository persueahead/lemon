package com.example.ln.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet{

	public MyServlet1() {
		System.out.println("-------MyServlet1初始化------------");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----MyServlet1-doGet------");
		req.getSession().setAttribute("info", "提示");
		req.getSession().invalidate();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----MyServlet1-doPost------");
	}
}
