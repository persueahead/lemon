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
 				��ȡ����  1970 1 1 0 0 0 
 			Date ��
 			   sql  util (����)  
 			 ��������
 			     Date()�޲����Ļ�ȡ���ص�ʱ��
 			   Date(long date)     
 			   getTime()  ��ȡ��ǰ����ʱ��ĺ���
 			   toString()
 			   �����ʻ�
 			 SimpleDateFormat
 			     ��ʽ���ͽ���
 			     ����  ->�ַ���
 			   XXXX.format(Date date);
 			    ������SimpleDateFormat��������������(yyyy-MM-dd .....)
 			  
 			  ����  �ַ���->  ����
 			  sim.parse(st);
 			     
 			 //Calender
 			   	Calendar  calendar=	Calendar.getInstance();
 			   	calendar.get(Calendar.DAY_OF_WEEK) API�ֶ�ժҪ
 			   	ע���ȡ���ڼ����� Ҫ1
 

	 */
	@Test
	public void test03() throws Exception {
	
		Calendar  calendar=	Calendar.getInstance();
		//  ��  1 2 3 4 5 6 
		int  I
		=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(I);
		//  ע��
		String [] arr= {"������","����1","����2","����3","����4","����5","����6"};
		System.out.println(arr[I-1]);
		
		
	}
	
	@Test
	public void test02() throws Exception {
		
		//��
		//��
		//ʱ��
		//��......
		Calendar  calendar=	Calendar.getInstance();
		
		  int  i=calendar.get(Calendar.YEAR);
		System.out.println(i);
		 int  J=calendar.get(Calendar.MONTH);
		System.out.println(J+1);
		 calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
		
	}
	
	
	
	
	//����    �ı�(�ַ���)  ����һ������  ���ڽ��и�ʽ����ʱ��
	@Test
	public void test01() throws Exception {
		SimpleDateFormat  sim
		=new SimpleDateFormat();
	String st=	sim.format(new Date());
	System.out.println(st);
		//����
	Date  dat=	sim.parse(st);
	System.out.println(dat);
	}
	
	//  SimpleDateFormat����ʽ��ʱ�䣿
	
	//��չ  �������
	@Test  //���ڲ��Ե�
	public  void  getTest() {
		//
		DateFormat  DATE=	   DateFormat.getDateInstance();
	
		
		//  ���� > �ַ���    �ַ���  >����  0  
		SimpleDateFormat  sim
		=new SimpleDateFormat("yyyyyyyy��MM��dd  HH:mm:ss");
		 String  dtr=sim.format(new Date());
		// xxx�� xxxx�� xxxx�� HH:mm:ss
		System.out.println(sim.format(new Date()));
		System.out.println(dtr);
		
	}
	
	
	
	@Test //���в���   
	 		// throws Exception   �쳣 
	public void testname() throws Exception {
		 System.out.println("----------------");
		//1970 1 1 00 00  00  
			//�޲��������ȡ����ʱ��
			//Date(....)
			Date  dt=  new Date();
			//������ �ı�׼
			System.out.println(dt);
			System.out.println(dt.toString());
		
			//1560341999145
			System.out.println(dt.getTime());//��ȡ����
		//  �����ʻ�   yyyy-MM-dd ?  2019 ��  4 �� ,......
			//Wed Jun 12 20:28:05 CST 2019
			Date  dt1=  new Date(dt.getTime());
			
			System.out.println(dt1);
			
		}
		
	
}
