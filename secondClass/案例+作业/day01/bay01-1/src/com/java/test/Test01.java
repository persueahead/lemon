package com.java.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class Test01 {

	/**
	 *
	 * System  package java.lang;
 				获取毫秒  1970 1 1 0 0 0 
 			Date 类
 			   sql  util (常用)  
 			 东八区的
 			     Date()无参数的获取本地的时间
 			   Date(long date)     
 			   getTime()  获取当前对象时间的毫秒
 			   toString()
 			   不国际化
 			 SimpleDateFormat
 			     格式化和解析
 			     日期  ->字符串
 			   XXXX.format(Date date);
 			    必须在SimpleDateFormat这个对象中添加上(yyyy-MM-dd .....)
 			  
 			  解析  字符串->  日期
 			  sim.parse(st);
 			     
 			 //Calender
 			   	Calendar  calendar=	Calendar.getInstance();
 			   	calendar.get(Calendar.DAY_OF_WEEK) API字段摘要
 			   	注意获取星期几和月 要1
 

	 */
	@Test
	public void test03() throws Exception {
	
		Calendar  calendar=	Calendar.getInstance();
		//  天  1 2 3 4 5 6 
		int  I
		=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(I);
		//  注意
		String [] arr= {"星期日","星期1","星期2","星期3","星期4","星期5","星期6"};
		System.out.println(arr[I-1]);
		
		
	}
	
	@Test
	public void test02() throws Exception {
		
		//年
		//月
		//时间
		//分......
		Calendar  calendar=	Calendar.getInstance();
		
		  int  i=calendar.get(Calendar.YEAR);
		System.out.println(i);
		 int  J=calendar.get(Calendar.MONTH);
		System.out.println(J+1);
		 calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
		
	}
	
	
	
	
	//解析    文本(字符串)  生成一个日期  日期进行格式化得时候
	@Test
	public void test01() throws Exception {
		SimpleDateFormat  sim
		=new SimpleDateFormat();
	String st=	sim.format(new Date());
	System.out.println(st);
		//解析
	Date  dat=	sim.parse(st);
	System.out.println(dat);
	}
	
	//  SimpleDateFormat，格式化时间？
	
	//扩展  不大纲中
	@Test  //用于测试的
	public  void  getTest() {
		//
		DateFormat  DATE=	   DateFormat.getDateInstance();
	
		
		//  日期 > 字符串    字符串  >日期  0  
		SimpleDateFormat  sim
		=new SimpleDateFormat("yyyyyyyy年MM月dd  HH:mm:ss");
		 String  dtr=sim.format(new Date());
		// xxx年 xxxx月 xxxx日 HH:mm:ss
		System.out.println(sim.format(new Date()));
		System.out.println(dtr);
		
	}
	
	
	
	@Test //进行测试   
	 		// throws Exception   异常 
	public void testname() throws Exception {
		 System.out.println("----------------");
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
		
	
}
