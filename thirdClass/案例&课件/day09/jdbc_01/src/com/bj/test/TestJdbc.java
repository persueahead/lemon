package com.bj.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class TestJdbc {

	/**
	 * 测试  连接数据的的信息 
	 *   使用jdbc进行连接
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT&characterEncoding=utf-8","root","wdylzyn");
		  //连接成功，返回一串语句com.mysql.cj.jdbc.ConnectionImpl@163e4e87
		 System.out.println(conn);
	}
	
	
	@Test
	public void testName01() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT&characterEncoding=utf-8","root","wdylzyn");
		 //创建一个Statement对象，用于执行静态的sql语句，并获得返回的结果
		 Statement  st=conn.createStatement();
		int i= st.executeUpdate(" INSERT  into  fruit VALUES(1,'苹果')");
		 System.out.println(i);
		 
		 st.close();
		 conn.close();
		 
		 
		 
		 System.out.println(conn);
	}
}
