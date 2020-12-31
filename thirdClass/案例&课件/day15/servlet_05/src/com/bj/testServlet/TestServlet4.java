package com.bj.testServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bj.pojo.Users;

/**
 * Servlet implementation class TestServlet01
 */
@WebServlet("/TestServlet04")
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	     //
		ArrayList  arr=	  new  ArrayList<>();
		Users  user=new Users();
		user.setAge("tom");
		user.setName("admin");
		user.setId(1);
		arr.add(user);	
		
		Users  user1=new Users();
		user1.setAge("jack");
		user1.setName("dylan");
		user1.setId(2);
		arr.add(user1);
		request.setAttribute("arrUser", arr);
		
		
		request.getRequestDispatcher("listUsers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
