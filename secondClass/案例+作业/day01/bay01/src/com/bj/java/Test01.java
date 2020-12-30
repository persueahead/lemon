package com.bj.java;

public class Test01 {

	public static void main(String[] args) {
		
		//有的1560341543760  这样的时间    util.date 
       long  om= System.currentTimeMillis();//毫秒    1970.1.1.0。0.0.0
       System.out.println(om);
       //睡觉
       try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//线程
       long  om1= System.currentTimeMillis();//毫秒    1970.1.1.0。0.0.0
       
       System.out.println(om1);
	}

}
