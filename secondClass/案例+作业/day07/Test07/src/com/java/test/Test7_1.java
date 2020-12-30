package com.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//匿名内部类来进创建线程
public class Test7_1 {
	
	//进行同步的代码
	public static void main(String[] args) {
		Test7  t6=  new Test7();
           new Thread(){
        	   public void run() {
        	     while(true) {
        	    	 t6.getVoid();
        	     }   
        	     }
           }.start();
           
           System.out.println("---------------同----------");
           new Thread(){
        	   public void run() {
        	     while(true) {
        	    	 t6.getVoid01();
        	     }   
        	     }
           }.start();
	}
}
