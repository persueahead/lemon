package com.bj.test.testthread;

public class TestLng {

	
	public static void main(String[] args) throws Exception {
		   new TestLng().testname01();
	}

	//匿名创建线程
	public void testname01() throws Exception {
		new Thread(new Runnable() {
			@Override
			public void run() {
				 for (int i = 0; i < 10; i++) {
					 System.out.println("我执行了线程:++++++::"+i);
				}
				
			}
		}).start();
	}	
	
	
	
	//匿名创建线程
	public void testname() throws Exception {
		   new Thread() {
			   public void run() {
				   for (int i = 0; i < 10; i++) {
					 System.out.println("我执行了线程:::"+i);
				}
		   }
	}.start();
}
}