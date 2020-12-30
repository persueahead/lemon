package com.bj.java01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bj.java.MyThisRuntimeException;

public class MyIsException2Test3 {


	public static  void getTest01() throws ParseException,IllegalAccessException   {
			SimpleDateFormat  sim
			=new SimpleDateFormat();
		String st=	sim.format(new Date());
		Date  dat=	sim.parse(st);
			 
	}
	
	
	public static  void getTest(){
		System.out.println("------------");
		throw  new MyThisRuntimeException();
		 
	}
	
	
	public static void main(String[] args) {
		
		 new  MyIsException2Test3().getTest();
	}
	
	
}
