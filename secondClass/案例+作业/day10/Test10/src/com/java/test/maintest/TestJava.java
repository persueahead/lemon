package com.java.test.maintest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.java.test.pojo.Users;

public class TestJava {

	/*
	 * 待会看
	//通过反射获取方法
	public static void tetst() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	Class user=	Users.class;
	//获取所有的方法
	Method[] method=   user.getMethods();
		for (Method m : method) {
			if(m.getName().contains("testname")) {
			Constructor  co=	user.getConstructor();
			Users  s=(Users)co.newInstance();
				m.invoke(s);
			}
		}}
	*/
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		try {
			test02();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取多个参数的方法
	public  static void test02() throws Exception {
		Users  users= new Users();
		 Class cu=users.getClass();
		   System.out.println("----------------");  
		   //注意的使用传入的类型必须是和该方法参数的类型相同
		   Method  me=   cu.getMethod("testname",String.class,int.class);
		   //Method  me=   cu.getMethod("testname",new Class[]{String.class,int.class});
		   Users  obj=  (Users)me.invoke(users, "陈不要脸",200003);
		System.out.println(obj);
	}
	
	
	//获取一个参数的方法
	public  static void test01() throws Exception {
		Users  users= new Users();
		 Class cu=users.getClass();
		   System.out.println("----------------");  
		   Method  me=   cu.getMethod("testname",new Class[]{String.class});
		   Users  obj=  (Users)me.invoke(users, "陈不要脸");
		System.out.println(obj);
	}
	
	
	
	
	
	
	


}
