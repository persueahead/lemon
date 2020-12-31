package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jdbc.pojo.Person;
import com.jdbc.utils.JDBCUtils;
/**
 *  jdbc  的查询语句
 * @author Administrator
 *
 */
public class TestJdbc2 {
		@Test
	public void testName06() throws Exception {
		testName05("'小张'  or  1=1 ",12);
	}
	
	public void testName05(String  pname,int  page) throws Exception {
		Connection  conn =JDBCUtils.getConnection();
		 String  sql="select * from person where page="+page+" and  pname="+pname;
//select * from person where page=1222  and   pname='小张'  or  1=1
		 //执行对应的sql语句
		 Statement  stat= conn.createStatement();
		 ResultSet  set=	 stat.executeQuery(sql);
		List list= new ArrayList<Person>();
		 	  while(set.next()) {
		 		 Person  per=  new  Person();
		 		per.setPid(set.getInt("pid"));
		 		per.setPname(set.getString("pname"));
				per.setPage(set.getInt("page"));
				list.add(per);
		 	  }
		 System.out.println(list);
		 JDBCUtils.getClose(conn, set, stat,null); 
	
	}
	
	
	
	
	/**
	 * 查询所有的数据并封装成对象
	 * @throws Exception
	 */
	@Test
	public void testName04() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://192.168.2.159:3306/testMysql?characterEncoding=utf-8","root","root");
		 System.out.println(conn);
		 
		 String  sql="select * from person ";
		 //执行对应的sql语句
		 Statement  stat= conn.createStatement();
		 ResultSet  set=	 stat.executeQuery(sql);
		List list= new ArrayList<Person>();
		 	  while(set.next()) {
		 		 Person  per=  new  Person();
		 		per.setPid(set.getInt("pid"));
		 		per.setPname(set.getString("pname"));
				per.setPage(set.getInt("page"));
				list.add(per);
		 	  }
		 System.out.println(list);
		 
		 
		 	set.close();
		 	stat.close();
		 	conn.close();
		 	
		 	
	}
	

	/**
	 * 查询所有的数据并封装成对象
	 * @throws Exception
	 */
	@Test
	public void testName03() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://192.168.2.159:3306/testMysql?characterEncoding=utf-8","root","root");
		 System.out.println(conn);
		 
		 String  sql="select * from person ";
		 //执行对应的sql语句
		 Statement  stat= conn.createStatement();
		 ResultSet  set=	 stat.executeQuery(sql);
		List list= new ArrayList<Person>();
		 	  while(set.next()) {
		 		 Person  per=  new  Person();
		 		per.setPid(set.getInt(1));
		 		per.setPname(set.getString(2));
				per.setPage(set.getInt(3));
				list.add(per);
		 	  }
		 System.out.println(list);
		 
		 
		 	set.close();
		 	stat.close();
		 	conn.close();
		 	
		 	
	}
	

	
	
	
	
	/**
	 * 查询所有的数据
	 * @throws Exception
	 */
	@Test
	public void testName02() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://192.168.2.159:3306/testMysql?characterEncoding=utf-8","root","root");
		 System.out.println(conn);
		 String  sql="select * from person ";
		 //执行对应的sql语句
		 Statement  stat= conn.createStatement();
		 ResultSet  set=	 stat.executeQuery(sql);
		 	  while(set.next()) {
		 		 int  in=	set.getInt(1);
				 	String  name=	set.getString(2);
				 	int  age=	set.getInt(3);
				 	System.out.println(in+","+name+","+age);
		 	  }
		 	set.close();
		 	stat.close();
		 	conn.close();
		 	
		 	
	}
	
	
	
	
	
	
	/**
	 * 查询数据单条数据
	 * @throws Exception
	 */
	@Test
	public void testName01() throws Exception {
		//加载驱动
		 Class.forName("com.mysql.jdbc.Driver");
		 //获取连接的对象
		 Connection  conn= DriverManager.getConnection("jdbc:mysql://192.168.2.159:3306/testMysql?characterEncoding=utf-8","root","root");
		 System.out.println(conn);
		 String  sql="select * from person where pid=2 ";
		 //执行对应的sql语句
		 Statement  stat= conn.createStatement();
		 ResultSet  set=	 stat.executeQuery(sql);
		 	set.next();
		 	int  in=	set.getInt(1);
		 	String  name=	set.getString(2);
		 	int  age=	set.getInt(3);
		 	System.out.println(in+","+name+","+age);
		 	set.close();
		 	stat.close();
		 	conn.close();
	}
	
	
}
