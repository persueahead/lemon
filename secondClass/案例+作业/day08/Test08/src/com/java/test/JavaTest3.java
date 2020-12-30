package com.java.test;

//线程的常用的方法
public class JavaTest3 {
	
	
	private static String s1="左筷子";
	private static String s2="右筷子";
	public static void main(String[] args) {
		 new Thread() {
			 public void run() {
				 while(true) {
					synchronized (s1) {
						System.out.println(getName()+"获取"+s1+"等待"+s2);
								synchronized (s2) {
									System.out.println(getName()+"获取"+s2+"开干");
								} 
					}
				 }
			 }
		 }.start();
		 new Thread() {
			 public void run() {
				 while(true) {
					synchronized (s2) {
						System.out.println(getName()+"获取"+s2+"等待"+s1);
								synchronized (s1) {
									System.out.println(getName()+"获取"+s1+"开干");
								}
					}
				 }
			 }
		 }.start();
	}
	
	
	

}
