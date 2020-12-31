package com.io.testbuffio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestBuffIO {

	  public static void main(String[] args) throws Exception {
		  new TestBuffIO().testname02();
	}
	
	  
	  //写中文
	  public void testname02() throws Exception {
		  FileOutputStream out=   new FileOutputStream("D:\\xxx\\oo\\xxxoo.txt",true);		  
		   out.write("柠檬同学好好学习天天向上".getBytes());
		   out.write("柠檬同学好好学习天天向上".getBytes());
		   out.write("柠檬同学好好学习天天向上".getBytes());
		   out.write("柠檬同学好好学习天天向上".getBytes());
           out.flush();
           out.close();
	  }  
	  
	  //字节流读取中文
	  public void testname01() throws Exception {
		
		  FileInputStream  input=   new FileInputStream("D:\\xxx\\oo\\xxxoo.txt");
		  byte[] by=  new byte[1024];      
		  int i;
		  while((i=input.read(by))!=-1) {
			  
			  String s=   new String(by,0,i);
			    System.out.println(s);
		  }
		  
		  input.close();
		  
		  
	}
	  
	  
	  /**
	   * 使用缓冲流进行拷贝图片
	   * @throws Exception
	   */
	  public void testname() throws Exception {
		  BufferedInputStream  buff=
				  new BufferedInputStream(new FileInputStream("D:\\xxx\\xxxx.jpg"));
		  
		  BufferedOutputStream  out=
				  new BufferedOutputStream(new FileOutputStream("D:\\xxx\\0000000.jpg"));
		  int i;
		  while((i=buff.read())!=-1) {
			  out.write(i);
		  }
		  out.flush();//就用来进行刷新缓冲区的，刷新了之后可以在次进行写出
		  			//刷新必须在关闭流之前进行刷新，
		  buff.close();//关闭整个流，关闭了之后就不在使用该流
		  out.close();
		  
		  
		  
		  
		  
		  
		  
		  
	}
	  
}
