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
 * Servlet implementation class Updata
 */
@WebServlet("/Updata")
public class Updata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updata() {
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
		String upname=request.getParameter("teachername");
		String upsex=request.getParameter("teacherSex");
		String age=request.getParameter("teacherAge");
		int upage=Integer.valueOf(age).intValue();
		String uptel=request.getParameter("teacherTel");
		String updept=request.getParameter("teacherDept");
		String upaddress=request.getParameter("teacherAddress");
		int upId=Integer.valueOf(request.getParameter("stId"));
		try {
			Quary.UpData(upname, upage, upsex, updept, uptel, upaddress, upId);
			Quary.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.setAttribute("teachers", Quary.getList());
		context.setAttribute("listLength", Quary.getLength());
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
