package com.bj.java;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//上节课知识点
public class TestJava {
	
	private String s="";
	
	
	

	public void getTest003()throws  ArithmeticException {
	}
	
	public void getTest002()throws  NullPointerException {
		getTest003();
	}
	
	
	//	try catch.....  finally的语法
	public void getTest01() {
		try {
		}catch ( ) {
			// TODO: handle exception
		}catch (  ) {
			// TODO: handle exception
		} finally {
		}
	}
	
	//try finally的语法
	public void getTest() {
		try {
		} finally {
		}
		
	}
	
	
	
	//编译异常
	public  void testGet05() {
	  
		SimpleDateFormat  sim
		=new SimpleDateFormat();
	String st=	sim.format(new Date());
	try {
		Date  dat=	sim.parse(st);
	} catch (ParseException e) {
		e.getMessage();
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
	//不能为0
	public  void testGet04() {
		 int  q=2/0;
		  System.out.println(q);
	}
	
	
	//空指针...
	public  void testGet02() {
		  int[] I= {1,3,4};
		  I=null;
		  System.out.println(I[2]);
	}
	
	
	
	
	
	public  void testGet01() {
		Calendar.getInstance();
	}
	
	
	public  void testGet() {
		
		System.currentTimeMillis();
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
