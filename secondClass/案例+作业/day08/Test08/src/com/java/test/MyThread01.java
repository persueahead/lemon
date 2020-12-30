package com.java.test;

public class MyThread01  extends Thread{

	private static int number=100;
	
	static Object  obj=new Object();

	public MyThread01() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyThread01(String name) {
		super(name);
	}

	@Override
	public void run() {
	  while(true) {
		 synchronized (obj) {
			 if(number<=0) {
				 break;
			 }
			 try {
				 	Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(getName()+":第"+number--+"号票"); 
		}
	  }	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
