package com.nm.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nm.util.Quary;

/**
 * Servlet implementation class AddUpdata
 */
@WebServlet("/AddUpdata")
public class AddUpdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUpdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context=this.getServletContext();
		context.removeAttribute("teachers");
		context.removeAttribute("listLength");
		String addname=request.getParameter("teachername");
		String addsex=request.getParameter("teacherSex");
		String addage=request.getParameter("teacherAge");
		int turnage=Integer.valueOf(addage).intValue();
		String addtel=request.getParameter("teacherTel");
		String adddept=request.getParameter("teacherDept");
		String addaddress=request.getParameter("teacherAddress");
		try {
			Quary.Add( addname, turnage, addsex, adddept, addtel, addaddress);			
			Quary.selectAll();
			context.setAttribute("teachers", Quary.getList());
			context.setAttribute("listLength", Quary.getLength());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("displayteacher.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
