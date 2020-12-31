package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jdbc.pojo.Person;
import com.jdbc.utils.JDBCUtils;
/**
 *  预编译
 * @author Administrator
 *
 */
public class TestJdbc3 {
	//修改数据  update  person  set pname='小李' WHERE pid=1
	@Test
	public void testName06() throws Exception {
		Connection  conn =JDBCUtils.getConnection();
		 //String  sql="update  person  set pname=? WHERE pid=? and XXXX ";
		//添加 删除  修改都是一样的操作只是sql不一样
		String  sql="update  person  set pname=? WHERE pid=? ";
		 PreparedStatement per= conn.prepareStatement(sql);
		 per.setString(1,"小张");
		 per.setInt(2,4);
	
		
		 int  i= per.executeUpdate();
		 System.out.println(i);
		 JDBCUtils.getClose(conn, null,null,per); 
	}
	/**
	 * 预编译  查询
	 * @throws Exception
	 */
	@Test
	public void testName05() throws Exception {
		Connection  conn =JDBCUtils.getConnection();
		 String  sql="select * from person where page=? and  pname= ? ";
		 PreparedStatement per= conn.prepareStatement(sql);
		 per.setInt(1,12);
		 per.setString(2,"小张");
		 ResultSet  set= per.executeQuery();//执行查询返回结果集
		 List array= new  ArrayList<Person>();
		 while(set.next()) {
			 Person  person= new Person();
			 person.setPid(set.getInt("pid"));
			 person.setPage(set.getInt("page"));
			 person.setPname(set.getString("pname"));
			 array.add(person);
		 }
		 System.out.println(array);
		 JDBCUtils.getClose(conn, set,null,per); 
	}
	
	
	
	
}
