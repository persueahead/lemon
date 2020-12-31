package com.nm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.nm.model.Teacher;
import com.nm.model.User;
import com.nm.util.MysqlConnection;

public class Manager {
private static ArrayList<User> managerList;
private static int managerLength;
private static HashMap<String,String> map;

public static ArrayList<User> getManagerList() {
	return managerList;
}

public static int getManagerLength() {
	return managerLength;
}

public static HashMap getMap() {
	return map;
}
//查询数据库管理员信息并打包
public static void  quary() throws Exception {
	Connection conn= MysqlConnection.C3p0Cinnection();
	String sql="SELECT * from manager";
	PreparedStatement pre=conn.prepareStatement(sql);
	ResultSet set=pre.executeQuery();
	 managerList=new ArrayList();
	 map=new HashMap<String, String>();
	while(set.next()) {	
		User manager=new User();
		manager.setId(set.getInt(1));
		String name=set.getString(2);
		String pass=set.getString(3);
		manager.setUsername(name);
		manager.setPassword(pass);
		managerList.add(manager);		
		map.put(name,pass);		
  }
	
	MysqlConnection.CloseResource(conn, set, null, pre);
	managerLength=managerList.size();
}
public static void resetPassword(String pass,String name) throws Exception {
	Connection conn= MysqlConnection.C3p0Cinnection();
	String sql="UPDATE manager SET password=? WHERE username=?";
	PreparedStatement pre=conn.prepareStatement(sql);
	pre.setString(1, pass);
	pre.setString(2, name);
	int result=pre.executeUpdate();
	System.out.println("result:"+result);
	MysqlConnection.CloseResource(conn, null, null, pre);
}
	
	  public static void main(String[] args) throws Exception { quary();
	  System.out.println(managerList);
	  
	  }
	 
}
