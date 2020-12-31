package com.nm.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nm.model.Teacher;

public class Quary {
private static ArrayList<Teacher> list;
private static int length;
public static ArrayList<Teacher> getList() {
	return list;
}
public static int getLength() {
	return length;
}
//查询所有，用list返回所有结果
public static void selectAll() throws Exception {
	Connection conn= MysqlConnection.C3p0Cinnection();
	String sql="SELECT * from teacher";
	PreparedStatement pre=conn.prepareStatement(sql);
	ResultSet set=pre.executeQuery();
	list=new ArrayList<Teacher>();
	while(set.next()) {
		Teacher teacher=new Teacher();
		teacher.setTeacherId(set.getInt(1));
		teacher.setTeachername(set.getString(2));
		teacher.setTeacherAge(set.getInt(3));
		teacher.setTeacherSex(set.getString(4));
		teacher.setTeacherDept(set.getString(5));
		teacher.setTeacherTel(set.getString(6));
		teacher.setTeacherAddress(set.getString(7));
		list.add(teacher);
	}
	length=list.size();
	MysqlConnection.CloseResource(conn, set, null, pre);

}
//查询工号,返回单个teacher
public static Teacher selectId(int id) throws Exception{
	Connection conn= MysqlConnection.C3p0Cinnection();
	String sql="SELECT * from teacher WHERE teacherId=?";
	PreparedStatement pre=conn.prepareStatement(sql);
	pre.setInt(1, id);
	ResultSet set=pre.executeQuery();
	Teacher teacher=new Teacher();
	set.next();	
		teacher.setTeacherId(set.getInt(1));
		teacher.setTeachername(set.getString(2));
		teacher.setTeacherAge(set.getInt(3));
		teacher.setTeacherSex(set.getString(4));
		teacher.setTeacherDept(set.getString(5));
		teacher.setTeacherTel(set.getString(6));
		teacher.setTeacherAddress(set.getString(7));
		
	
	MysqlConnection.CloseResource(conn, set, null, pre);
	return teacher;
}
//添加
public static void Add(String name,int age,String sex,String dept,String tel,String address) throws Exception {
	Connection conn= MysqlConnection.C3p0Cinnection();
	String sql="INSERT INTO teacher(teachername,teacherAge,teacherSex,teacherDept,teacherTel,teacherAddress) VALUES(?,?,?,?,?,?)";
	PreparedStatement pre=conn.prepareStatement(sql);
	pre.setString(1, name);
	pre.setInt(2, age);
	pre.setString(3, sex);
	pre.setString(4, dept);
	pre.setString(5, tel);
	pre.setString(6, address);
	int i=pre.executeUpdate();
	System.out.println(i);
	MysqlConnection.CloseResource(conn, null, null, pre);
}
//删除
public static void  delet(int modifire) throws Exception {
	Connection conn= MysqlConnection.C3p0Cinnection();
	String sql="DELETE FROM teacher WHERE teacherId=?";
	PreparedStatement pre=conn.prepareStatement(sql);
	pre.setInt(1, modifire);
	int result=pre.executeUpdate();
	System.out.println(result);
	MysqlConnection.CloseResource(conn, null, null, pre);
}
//更新
public static void UpData(String name,int age,String sex,String dept,String tel,String address,int id ) throws Exception {
	Connection conn= MysqlConnection.C3p0Cinnection();
	String sql="UPDATE teacher SET teachername=?,teacherAge=?,teacherSex=?,teacherDept=?,teacherTel=?,teacherAddress=?\r\n" + 
			" WHERE teacherId=?";
	PreparedStatement pre=conn.prepareStatement(sql);
	pre.setString(1, name);
	pre.setInt(2, age);
	pre.setString(3, sex);
	pre.setString(4, dept);
	pre.setString(5, tel);
	pre.setString(6, address);
	pre.setInt(7, id);
	int result=pre.executeUpdate();
	System.out.println(result);
	MysqlConnection.CloseResource(conn, null, null, pre);
}
public static void main(String[] args) throws Exception {
	selectAll();
	System.out.println(list);
	System.out.println(length);
}
}
