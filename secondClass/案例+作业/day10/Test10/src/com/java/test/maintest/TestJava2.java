package com.java.test.maintest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.java.test.pojo.Users;

public class TestJava2 {

	
	public static void main(String[] args) throws Exception {
		
		test04();
		
		
	}
	//设置私有的属性值
	public static void test04() throws Exception {
		Users us=	new Users("小张","陈二狗",12,21);
		Users  users= new Users();
		 Class cu=users.getClass();
		 Field fe= cu.getDeclaredField("name");
		 //开启私有可用
		 fe.setAccessible(true);
        System.out.println(fe.get(us));
        System.err.println("-----------------------");
        fe.set(us,"董小姐");
        System.out.println(fe.get(us));
	}
	
	
	//设置public属性的值
	public static void test03() throws Exception {
		Users us=	new Users("小张","陈二狗",12,21);
		Users  users= new Users();
		 Class cu=users.getClass();
		 Field fe= 	cu.getField("lastName");
		  System.out.println(fe.get(us));
		System.out.println("-------------------------------");
		  fe.set(us, "陈不要脸");
		  System.out.println(fe.get(us));
	}
	
	//所有所用的属性包括私有的
			public static void test02() throws Exception {
				Users  users= new Users();
				 Class cu=users.getClass();
				 Field[] f=	cu.getDeclaredFields();
				 for (Field field : f) {
					 
					 System.out.println("field+"+field);
					 System.out.println("field+"+field.getName());
				}
			}
	
	
	
	
				//获取公共属性
			public static void test01() throws Exception {
				Users  users= new Users();
				 Class cu=users.getClass();
				 Field[] f=	cu.getFields();
				 for (Field field : f) {
					 System.out.println("field+"+field);
				}
			}
	
	

	
	
	
	
	
	
	
	


}
