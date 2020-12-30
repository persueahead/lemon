package com.test.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


//缓冲流
public class TestJava2 {

	public static void main(String[] args) throws IOException, InterruptedException {

		getVoid02();
		
	
	}
	
	
	//写
	public  static void getVoid02() throws IOException {
		FileOutputStream  fos=	 new FileOutputStream("E:\\IO\\111.txt",true);
		fos.write("同学们你们好呀".getBytes());
		fos.write("\r\n".getBytes());//换行
		fos.write("同学们你们好呀".getBytes());
		fos.close();
	}
	//读中文
	public  static void getVoid01() throws IOException {
		FileInputStream  fis=new FileInputStream("E:\\IO\\111.txt");
		  byte[] arr=new byte[1024];
		   int i;
		    while((i=fis.read(arr))!=-1) {
		    	//转换为字符串
		    	  System.out.println(new String(arr, 0, i));
		    }
		    fis.close();
	}
	
	
	
	
	
	
	
	
	//读数据
	public  static void getVoid() throws IOException {
		//使用了BufferedInputStream  缓冲流,对输入的流进行包装
		BufferedInputStream  bis=	new BufferedInputStream(new FileInputStream("E:\\IO\\授课桌面背景.jpg"));		
	   //使用缓冲流进行包装输出
		BufferedOutputStream  bos=	new BufferedOutputStream(new FileOutputStream("E:\\\\IO\\\\BUFF授课桌面背景.jpg"));
		int b;
		while((b=bis.read())!=-1) {
			 bos.write(b);
		}
		bos.flush();//用于刷新缓冲区,跟催的意思
		bis.close();//关闭
		bos.close();
	}
	
	
	
	
	

}
