package com.bj.test.testthread;

//创建一个线程
public class TestThread {
	public static void main(String[] args) {
		MyThread  th=   new MyThread();
		th.start();//开启线程
	}
}
class MyThread extends Thread{

	@Override
	public void run() {
   for (int i = 0; i < 10; i++) {
	 System.out.println("我执行了线程:::"+i);
}
	
	
	}
	
	
	
}