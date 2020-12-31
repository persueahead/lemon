package com.nm.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MysqlConnection {
//c3p0连接数据库
public static Connection C3p0Cinnection() throws Exception {
	//创建数据库连接池对象
	DataSource  data=new ComboPooledDataSource();
	//获取连接对象
	Connection conn=data.getConnection();
	System.out.println("是否连接成功："+conn);
	return conn;
}

/**
 * 关闭资源
 * @throws Exception 
 */
public static void CloseResource(Connection conn,ResultSet set,Statement stat,PreparedStatement  ps) throws Exception {
		if(ps !=null) {
			ps.close();
		}
		if(stat !=null) {
			stat.close();
		}
		if(set !=null) {
			set.close();
		}
		if(conn !=null) {
			conn.close();
		}
	}
/*public static void main(String[] args) throws Exception {
	C3p0Cinnection();
}*/
}

