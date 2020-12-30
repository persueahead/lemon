package com.bj.java;

import java.util.Date;

public class Test02 {

	
	
	
	
	
	
	//时间
	//  Date   是常用的  util  sql 
	public  static  void getTest() {
		//1970 1 1 00 00  00  
		//无参数就算获取本地时间
		//Date(....)
		Date  dt=  new Date();
		//东八区 的标准
		System.out.println(dt);
		System.out.println(dt.toString());
	
		//1560341999145
		System.out.println(dt.getTime());//获取毫秒
	//  不国际化   yyyy-MM-dd ?  2019 年  4 月 ,......
		//Wed Jun 12 20:28:05 CST 2019
		Date  dt1=  new Date(dt.getTime());
		
		System.out.println(dt1);
		
	}
	public  static  void getTest01() {
		java.sql.Date  dt=  new java.sql.Date(2011,12,2);
		
		//东八区 的标准
		System.out.println(dt);
		System.out.println(dt.toString());
		
		//1560341999145
	}
	
	
	
	
	public static void main(String[] args) {
		getTest();
		
	}
}
