package com.java.test;

public class MyThread  extends Thread{
	@Override
	public void run() {
		 for (int i = 0; i < 20; i++) {
			 if(i%5==0) {
				   Thread.yield();
				   System.out.println("礼让线程"+getName()+":"+i);
			 }
			 System.out.println(getName()+":"+i);
		}
	}
}
