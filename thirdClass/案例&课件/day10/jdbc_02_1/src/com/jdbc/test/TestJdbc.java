package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;
/**
 *  jdbc的入门案列
 * @author Administrator
 *
 */
public class TestJdbc {
	
	
	
	
	
	
	
	
	/**
	 * 修改数据
	 * @throws Exception
	 */
	@Test
	public void testName03() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://192.168.2.159:3306/testMysql?characterEncoding=utf-8","root","root");
		 System.out.println(conn);
		 
		 String  sql="delete from person where pid=1 ";
		 //执行对应的sql语句
		 
		 Statement   stmt= conn.createStatement();
	  int  i=	 stmt.executeUpdate(sql);
	 System.out.println(i);
	 stmt.close();
	 conn.close();
	}
	/**
	 * 修改数据
	 * @throws Exception
	 */
	@Test
	public void testName02() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://192.168.2.159:3306/testMysql?characterEncoding=utf-8","root","root");
		 System.out.println(conn);
		 String  sql="update  person  set pname='小李' WHERE pid=1";
		 //执行对应的sql语句
		 Statement   stmt= conn.createStatement();
	  int  i=	 stmt.executeUpdate(sql);
	 System.out.println(i);
	 stmt.close();
	 conn.close();
	}
	
	
	
	/**
	 * 添加数据
	 * @throws Exception
	 */
	@Test
	public void testName01() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://192.168.2.159:3306/testMysql?characterEncoding=utf-8","root","root");
		 System.out.println(conn);
		 
		 String  sql="insert  into person(pname,page) VALUES ('小张',12)";
		 //执行对应的sql语句
		 
		 Statement   stmt= conn.createStatement();
	  int  i=	 stmt.executeUpdate(sql);
	 System.out.println(i);
	 stmt.close();
	 conn.close();
	}
	
	
	
	
	
	
	/*
	 * 测试数据连接
	 * */
	@Test
	public void testName() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://192.168.2.159:3306/testMysql?characterEncoding=utf-8","root","root");
		 System.out.println(conn);
	}
	
	
}
