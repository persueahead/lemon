package com.bj.testservlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestImgServlet
 */
@WebServlet("/TestImgServlet")
public class TestImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    //编写验证码
		  int  width=100;
		  int  height=30;
		  //创建一个对象。就是存储图片的
		  BufferedImage  image=  new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		  
		   //美化图片
		       //搞上颜色
		  Graphics  g= image.getGraphics();//笔对象
		     //设置颜色
		  g.setColor(Color.pink);
		  g.fillRect(0, 0, width, height);
		  
		  //边框
		  g.setColor(Color.red);
		  g.drawRect(0, 0, width-1, height-1);
		  
		  //设置验证码显示的字符
		  String  str="QWERTYUIOPlkjhgfdsa1234567890MNBVcvxz";
        //创建随机数
		  Random  rendom=    new Random();
		    
		  StringBuffer  sb=	  new  StringBuffer();
		   
		   for (int i = 1; i <= 4; i++) {
			int  index=rendom.nextInt(str.length());
			//取出字符
				char  ch=	str.charAt(index);
				sb.append(ch);
				//写验证码
			g.drawString(ch+"", width/5*i, height/2);	
		}
		   
		String  code=   sb.toString();
		  //将验证码存入Session
		request.getSession().setAttribute("checkCode_session", code);
		  
		//生成图片上的线条
		 g.setColor(Color.green);
		 for (int i = 0; i < 10; i++) {
			int  x1=rendom.nextInt(width);
			int  x2=rendom.nextInt(width);
			int  y1=rendom.nextInt(height);
			int  y2=rendom.nextInt(height);
			g.drawLine(x1, y1, x2, y2); 
		}
		 //将图片返回到页面
		 ImageIO.write(image, "jpg", response.getOutputStream());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
