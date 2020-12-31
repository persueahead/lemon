package com.bj.test.testthread;
/**
 * 执行礼让线程
 * @author Administrator
 */
class  MyTh extends  Thread{

	@Override
	public void run() {
   for (int i = 0; i < 28; i++) {
   if(i==20) {
	   Thread.yield();
	  System.out.println(getName()+"执行礼让线程");
   }
   
   System.out.println(getName()+"让线程==="+i);   
}
	}
}


public class TestLngMt {

	
	public static void main(String[] args) throws Exception {
		/*
		 * new MyTh().start(); new MyTh().start();
		 */
	new TestLngMt().testname06();
	}
	
	
	
	public void testname06() throws Exception {
		
		   Thread th=  new Thread() {
			   public void run() {
				   for (int i = 0; i < 50; i++) {
					   System.out.println("1号的线程===="+i);
					}
				   }
			   };
			   Thread th1=  new Thread() {
				   public void run() {
					   for (int i = 0; i < 50; i++) {
						   System.out.println("2号的线程===="+i);
						}
					   }
				   };
				   
				   //访问最小1最大是10
				   
				   th.setPriority(Thread.MAX_PRIORITY);
				   th1.setPriority(Thread.MIN_PRIORITY);
				   
					 th.start();
					th1.start();
	}
	
	
	
	/**
	 * 加入线程
	 * @throws Exception
	 */
	public void testname05() throws Exception {
		Thread th=  new Thread() {
			   public void run() {
				   for (int i = 0; i < 50; i++) {
					   System.out.println("1号的线程===="+i);
					}
				   }
			   };
				Thread th2=  new Thread() {
					   public void run() {
						   for (int i = 0; i < 50; i++) {
							   if(i==3) {
								   try {
									th.join();//插入指定的实际，之后进行交替的执行
									System.out.println("=======1号的线程_插入====");
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}// 
							   }
							   System.out.println("2号的线程===="+i);
							   
							}
						   }
					   };
					 th.start();
					th2.start();
					
	}
	
	/**
	 * 守护线程
	 * @throws Exception
	 */
	public void testname04() throws Exception {
		Thread th=  new Thread() {
			   public void run() {
				   for (int i = 0; i < 10; i++) {
					   System.out.println("线程一执行10次中的===="+i);
					}
				   }
			   };
	  th.start();
	  
		Thread th2=  new Thread() {
			   public void run() {
				   for (int i = 0; i < 100; i++) {
					   System.out.println("二号线程===="+i);
					}
				   }
			   };
			   th2.setDaemon(true);//设置为守护线程
	  th2.start(); 
	}
	
	/**
	 * 休眠，睡觉(毫秒为单位)
	 * @throws Exception
	 */
	public void testname03() throws Exception {
		Thread th=  new Thread("隔壁小姐姐") {
			   public void run() {
				   for (int i = 0; i < 10; i++) {
					   try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 System.out.println("我执行了线程:::"+i);
				   }
			   } 
	  };
	   System.out.println(Thread.currentThread().getName());
	  th.start();
	}
	
	
	
	
	
	/**
	 * 获取当前线程的名称
	 * @throws Exception
	 */
	public void testname02() throws Exception {
		Thread th=  new Thread("隔壁小姐姐") {
			   public void run() {
				   for (int i = 0; i < 10; i++) {
					 System.out.println("我执行了线程:::"+i);
				   }
			   } 
	  };
	   System.out.println(Thread.currentThread().getName());
	  th.start();
	}
	
	
	/**
	 * 设置线程的的名称
	 * @throws Exception
	 */
	public void testname01() throws Exception {
		Thread th=  new Thread("隔壁小姐姐") {
				   public void run() {
					   for (int i = 0; i < 10; i++) {
						 System.out.println("我执行了线程:::"+i);
					   }
				   } 
		  };
		   System.out.println(th.getName());
		  th.start();
	}
	/**
	 * 设置线程的的名称
	 * @throws Exception
	 */
	public void testname() throws Exception {
		Thread th=  new Thread() {
				   public void run() {
					   this.setName("隔壁老陈");
					   for (int i = 0; i < 10; i++) {
						 System.out.println("我执行了线程:::"+i);
					   }
					   System.out.println(this.getName());
				   } 
		  };
		  
		   System.out.println(th.getName());
		  
		  th.start();
	}	
}