package com.bj.test.testthread;

public class TestRunnable {

	public static void main(String[] args) {
      //开启线程
		TestRunable  tr=   new TestRunable();
		Thread th=new Thread(tr);
		th.start();//开启线程
	}
}

class  TestRunable implements Runnable{
	@Override
	public void run() {
     for (int i = 0; i < 10; i++) {
		System.out.println("我执行了线程+++"+i);
	}		
	}
}