package com.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//进行同步的代码
public class Test8 {
	public  synchronized  void getVoid() {
		  System.out.print("一号:");
		  System.out.print("同");
		  System.out.print("步");
		  System.out.print("代");
		  System.out.print("码");
		  System.out.print("\r\n");
	}
	public synchronized  void getVoid01() {
		  System.out.print("二号:");
		  System.out.print("同");
		  System.out.print("步");
		  System.out.print("代");
		  System.out.print("码");
		  System.out.print("\r\n");
	}
	
	


}
