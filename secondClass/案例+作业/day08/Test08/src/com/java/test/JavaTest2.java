package com.java.test;

//线程的常用的方法
public class JavaTest2 {
	public static void main(String[] args) {
		testname01();
	}
	
	//多线程购票
	public static void testname01() {
		MyThread01  t1= new MyThread01();
		MyThread01  t2= new MyThread01();
		MyThread01  t3= new MyThread01();
		MyThread01  t4= new MyThread01();
		t1.setName("窗口t1");
		t2.setName("窗口t2");
		t3.setName("窗口t3");
		t4.setName("窗口t4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		
	}
	
	
	

}
