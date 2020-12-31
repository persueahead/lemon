package servlet_02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Users;

/**
 * 用户提交数据
 * 获取对应数据到封装对象中
 * Servlet implementation class TestServlet_04
 */
@WebServlet("/TestServlet_04")
public class TestServlet_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//格式化，请求的字符集
		request.setCharacterEncoding("utf-8");
		//格式化响应的字符集
		response.setCharacterEncoding("utf-8");
		
		//处理中文乱码
		/*
		 * 1.jsp页面的字符集的格式 
		 * 2. tomcat中的配置文件(serivce.xml)的字符集
		 *          <Connector port="8080" protocol="HTTP/1.1"
		               connectionTimeout="20000"
		               redirectPort="8443" URIEncoding="UTF-8" />
		 * 3.开发工具的字符集格式
		 * 4.request和response有没有进行设置字符集||拦截器有没有设置
		 *   注意:get请求乱码tomcat设置了 URIEncoding="UTF-8"会进处理
		 *     而是没有办法进行处理需要手的的设置
		 *     		request.setCharacterEncoding("utf-8");
					response.setCharacterEncoding("utf-8");
		 *    
		 */
		
		//获取对应的数据并进行组装成一个对象
	      //获取数据，该方法返回的是字符串
		String name=	request.getParameter("name");
		String pwd=	request.getParameter("pwd");
		String phone=	request.getParameter("phone");
		String age=	request.getParameter("age");
		
	      //创建实体对象，接收数据
		Users  useer=new Users();
		useer.setName(name);
		useer.setPhone(phone);
		useer.setPwd(pwd);
		//需要进行转换，将age字符串转换成int类型
			useer.setAge(Integer.parseInt(age));
			//打印输出age，看是否转换成功
		System.out.println(age);
		System.out.println(useer);
		//调用Serivce层
	
	
	}

	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
