package com.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//jvm线程
public class Test2 {

public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		  for (int i = 0; i <8; i++) {
			  		  new Finalize();
		  }
		  for (int i = 0; i <8; i++) {
	  		 System.out.println("----主程序..............");
	  		 System.gc();
		  	}
	}
}
class  Finalize{
	@Override
	protected void finalize() throws Throwable {
      System.out.println("我清理了..............");
	}
}