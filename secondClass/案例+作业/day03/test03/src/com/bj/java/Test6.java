package com.bj.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

//Iterator的使用
public class Test6 {

	
	public static void main(String[] args) {
		test02();
	}
	
	

	//ListIterator 遍历 
	public static void test02()  {
		ArrayList  arr=  new ArrayList();
		arr.add(1231231231);
		arr.add("123123123123123123");
		arr.add(new Date());
		ListIterator  lsit=	arr.listIterator();
		while(lsit.hasNext()) {//it.hasNext()有没有元素
			System.out.println(lsit.next());
			System.out.println("------------");
		}
		
		
	}
	
	
	//Iterator 遍历 
	public static void test01()  {
		ArrayList  arr=  new ArrayList();
		arr.add(123);
		arr.add("1212312");
		arr.add(new Date());
		Iterator  it=  	arr.iterator();
		   it.next();
		   it.remove();//少，除业务逻需要的
		while(it.hasNext()) {//it.hasNext()有没有元素
			System.out.println(it.next());
			System.out.println("------------");
		}
		System.out.println("-------------------it.remove();----");
		
	}
	
}
