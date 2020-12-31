package com.bj.test.testsynch;
/**
 * 购票案例
 */
public class TestSynch02 {

	public static void main(String[] args) {
		MyThred T=new MyThred();
             new Thread(T).start();
             new Thread(T).start();
             new Thread(T).start();
             new Thread(T).start();
             new Thread(T).start();
	}
	
	

}

class MyThred implements Runnable{
	//定义票数
	private  static int number=100;
	static Object obj=new Object();
	@Override
	public void run() {
		  while(true) {
			  synchronized(this) {
				  if(number<=0) {
					  break;
				  }
				  try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println(Thread.currentThread().getName()+"第"+number--+"号票");
			  }
		  }
		
	}
	
}


