package com.bj.java;

import java.util.Date;

public class Test02 {

	
	
	
	
	
	
	//ʱ��
	//  Date   �ǳ��õ�  util  sql 
	public  static  void getTest() {
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
	public  static  void getTest01() {
		java.sql.Date  dt=  new java.sql.Date(2011,12,2);
		
		//������ �ı�׼
		System.out.println(dt);
		System.out.println(dt.toString());
		
		//1560341999145
	}
	
	
	
	
	public static void main(String[] args) {
		getTest();
		
	}
}
