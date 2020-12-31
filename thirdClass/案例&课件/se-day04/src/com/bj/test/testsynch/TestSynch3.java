package com.bj.test.testsynch;

public class TestSynch3 {
   private  static  String s1="左筷子";
   private  static  String s2="右筷子";
	public static void main(String[] args) throws Exception {
		new Thread() {
			public void run() {
				 while(true) {
					 synchronized(s1){
						 System.out.println(getName()+"得到了:"+s1+"--等待"+s2);
					 } 
					 synchronized(s2){
						 System.out.println(getName()+"得到了:"+s2+"--开吃");
					
					 } 
				}
			}
		}.start();
		new Thread() {
			public void run() {
				 while(true) {
					 synchronized(s2){
						 System.out.println(getName()+"得到了:"+s2+"--等待"+s1);
					 }
					 synchronized(s1){
						 System.out.println(getName()+"得到了:"+s1+"--开吃");
					 }
				}
			}
		}.start();
	}
}
