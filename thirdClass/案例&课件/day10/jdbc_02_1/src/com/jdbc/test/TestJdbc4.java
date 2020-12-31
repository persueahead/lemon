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
 *  事务 案列
 *    要么一起成功要么一起失败
 */
public class TestJdbc4 {
	
	
	@Test
	public void testname() throws Exception {
		Connection  conn=null;
		PreparedStatement   pr1=null;
		PreparedStatement   pr2=null;
		try {
			//默认的提交自动提交，修改成手动提交
			conn=JDBCUtils.getConnection();
			//autoCommit - 为 true 表示启用自动提交模式；为 false 表示禁用自动提交模式 
				conn.setAutoCommit(false);
				//写逻辑
				String  sql1="update person  set monery= monery-? where pid=? ";
				String  sql2="update person  set monery= monery+? where pid=? ";
				pr1=conn.prepareStatement(sql1);	
				pr2=conn.prepareStatement(sql2);	
					//设置参数
				pr1.setInt(1,1000);
				pr1.setInt(2,2);
				//设置参数
				pr2.setInt(1,1000);
				pr2.setInt(2,3);
				pr1.executeUpdate();
						int i=1/0;
						System.out.println(i);
				pr2.executeUpdate();
				//进行提交数据
				conn.commit();
				//将提交数据的方式设置回去
				conn.setAutoCommit(true);
				pr1.close();
				pr2.close();
				conn.close();
			
		} catch (Exception e) {
			//如提交的数据失败了进行回滚
			conn.rollback();
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
