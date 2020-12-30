package com.java.test;

//线程的常用的方法
public class JavaTest01 {
	public static void main(String[] args) {
		testname07();
	}
	

	//线程的优先设置
	public static void testname07() {
		Thread t=new Thread(){
			  public void run() {
				   for (int i = 0; i < 6; i++) {
					   System.out.println(getName()+"..........");
				   }
			  }
		  };
		  
			Thread t1=new Thread(){
				  public void run() {
					   for (int i = 0; i < 6; i++) {
						   System.out.println(getName()+"=========");
					   }
				  }
			  };
		/*
		 * t.setPriority(1); 
		 * t1.setPriority(10); //设置的权限级别最大
		 */		  
			  t.setPriority(Thread.MIN_PRIORITY);
			  t1.setPriority(Thread.MAX_PRIORITY);//设置的权限级别最大
		t.start();
		t1.start();
	}
	
	//加入线程
	public static void testname06() {
		 new MyThread().start();
		 new MyThread().start();
		
	}
	
	
	
	//加入线程
	public static void testname05() {
			//设置名称  
		Thread t1=new Thread(){
				  public void run() {
					   for (int i = 0; i < 6; i++) {
						   System.out.println(getName()+"..........");
					   }
				  }
			  };
			  System.out.println("--------------------");
			  Thread  t2=	new Thread(){
					  public void run() {
						   for (int i = 0; i < 20; i++) {
							   
							     if(i==4){
							    	 //插队的指定的时候,交替的执行
							    	try {
										t1.join();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}   
							     }
							     System.out.println(getName()+"=====");
							   
						   }
					  }
				  }; 
				  t1.start();
				  t2.start();
		}
	
	
	//守护线程
	public static void testname04() {
			//设置名称  
			new Thread(){
				  public void run() {
					   for (int i = 0; i < 6; i++) {
						   System.out.println(getName()+"..........");
					   }
				  }
			  }.start();
			  System.out.println("--------------------");
			  Thread  t2=	new Thread(){
					  public void run() {
						   for (int i = 0; i < 20; i++) {
							   System.out.println(getName()+"====");
						   }
					  }
				  }; 
				  //设置为守护线程
				  t2.setDaemon(true);
				  t2.start();
		}
	
	
	
	
	
	
	//线程休眠(按照毫秒进行计算的)
	public static void testname03() {
		//设置名称  
		new Thread(){
			  public void run() {
				   for (int i = 0; i < 20; i++) {
					   try {
						   //色休眠的时间.毫秒计算的
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   System.out.println("线程:"+i+"号");
				}
			  }
		  }.start();
	}
	
	
	
	
	//获取正在执行的线程
	public static void testname02() {
		//设置名称  
		new Thread(){
			  public void run() {
				  System.out.println("获取正在执行的线程");
				  Thread.currentThread().setName("我只是主线程中线程");
				  System.out.println(Thread.currentThread().getName());
			  }
		  }.start();
	}
	
	
	
	
	public static void testname() {
		//设置名称  
		new Thread(){
			  public void run() {
				  //设置线程对象名称的方法
				  this.setName("小王");
				   System.out.println("获取的名称:"+this.getName()+"");
			  }
		  }.start();
	}
	
	//可以通过构造函数
	public static void testname01() {
		//设置名称    //设置线程对象名称的方法
		new Thread("小张"){
			  public void run() {
				   System.out.println("获取的名称:"+this.getName()+"");
			  }
		  }.start();
	}
	
	
	

}
