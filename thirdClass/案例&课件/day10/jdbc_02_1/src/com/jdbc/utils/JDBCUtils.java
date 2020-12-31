package com.jdbc.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class JDBCUtils {

	private  static String jdbc_driver;
	private  static String jdbc_url;
	private  static String jdbc_user;
	private  static String jdbc_pwd;
	//文件的读取,并进行加载驱动
	static {
		   //读取文件并获取到值
		Properties  per=    new Properties();
		//获取类加载器
		ClassLoader  classLoader=	JDBCUtils.class.getClassLoader();
		URL  re=	classLoader.getResource("jdbc.properties");
		String path=	re.getPath();
		try {
			per.load(new  FileReader(path));
			//获取对应的数据
			jdbc_driver=per.getProperty("jdbc_driver"); 
			jdbc_url=	per.getProperty("jdbc_url"); 
			jdbc_user=per.getProperty("jdbc_user"); 
			jdbc_pwd=per.getProperty("jdbc_pwd"); 
			//加载驱动
			Class.forName(jdbc_driver);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取连接数据资源对象
	 */
	public static Connection getConnection() throws Exception {
		Connection  conn=	DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_pwd);
		return  conn;
	}	
	
	
	/**
	 * 关闭资源
	 * @throws Exception
	 */
	public  static void getClose(Connection conn,ResultSet set,Statement stat,PreparedStatement  ps) throws Exception {
	
		if(ps !=null) {
			ps.close();
		}
		if(stat !=null) {
			stat.close();
		}
		if(set !=null) {
			stat.close();
		}
		if(conn !=null) {
			stat.close();
		}
	}
	
	
	@Test
	public void testConnection() throws Exception {
		Connection  conn=getConnection();
		System.out.println(conn);
	}
	
}
