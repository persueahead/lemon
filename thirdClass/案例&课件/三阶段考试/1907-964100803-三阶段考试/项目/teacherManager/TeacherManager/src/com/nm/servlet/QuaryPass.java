package com.nm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nm.model.Teacher;
import com.nm.util.Quary;

/**
 * Servlet implementation class Quary
 */
@WebServlet("/Quarypass")
public class QuaryPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuaryPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取查询的工号
		   String str= request.getParameter("searchId");
		   int id=Integer.valueOf(str).intValue();
		   Teacher selectTeacher=null;
		   try {
			 selectTeacher=Quary.selectId(id);
			
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   ServletContext context=this.getServletContext();
			  context.setAttribute("selecTeachertById", selectTeacher);
			  context.setAttribute("selectid", id);
			 	response.sendRedirect("showteacher.jsp");
		   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
