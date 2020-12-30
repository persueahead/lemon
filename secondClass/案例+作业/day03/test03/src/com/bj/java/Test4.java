package com.bj.java;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Vector;

//LinkedList
public class Test4 {

	
	public static void main(String[] args) {
		test02();
		new ArrayList().add(e);
	}
	
	
	
	
	
	
	
	//了解下
	public static void test02()  {
		Vector  list=	  new Vector();
		list.add("a");
		list.add("B");
		 Enumeration  en= list.elements();
		 while(en.hasMoreElements()) {//判断是否有元素
			System.out.println(en.nextElement()); 
		 }
		
		
	
	}
	//
	public static void test01()  {
		Vector  list=	  new Vector();
		list.add("123123");
		list.add("123123");
		list.add("123123");
		list.add("123123");
		list.add("123123");
		
		for (Object object : list) {
			System.out.println(object);
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	
	}
	
	
	
}
