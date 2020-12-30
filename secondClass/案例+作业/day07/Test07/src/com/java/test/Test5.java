package com.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//匿名内部类来进创建线程
public class Test5 {
	//Thread
	public  static void getVoid() {
		   new Thread(){
			     public void run() {
			    	 for (int i = 0; i < 8; i++) {
			    		 //业务逻辑写上
						System.out.println("+++"+i);
					}
			     }
		   }.start();
	}
	
	//接口
	public static void getVoid01() {
		  new Thread(new Runnable() {
			@Override
			public void run() {
				//写上业务逻辑
				for (int i = 0; i <5; i++) {
					System.out.println("======="+i);
				}
			}
		}).start();
	}
	
	
public static void main(String[] args) {
	getVoid01();
}
}
