package com.java.test;

import java.util.LinkedList;

//2-6.使用LinkedList模拟栈结构
public class Test02 {

	

	
	//先进后出
	public static void main(String[] args) {

		St  s=  new St();
		s.in("1");
		s.in("2");
		s.in("3");
		s.in("4");
		while(!s.isNull()) {
			System.out.println(s.ou());
			
			
			
		}
		
		
	}

	
	
}


class St{
		LinkedList  li=  new LinkedList();
		
		//模拟进栈的方法
		 public void in(Object obj)
		 {
			 li.addLast(obj);
		 }		
		
		//拟出栈的方法
		 public Object ou()
		 {
			 return   li.removeLast();
		 }		
		
		//栈结构是否为空
		 public boolean isNull()
		 {
			 return li.isEmpty();
		 }	
	
}