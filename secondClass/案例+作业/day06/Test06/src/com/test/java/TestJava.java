package com.test.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


//字节流
public class TestJava {

	public static void main(String[] args) throws IOException, InterruptedException {
		getVoid04();
	}
	
	
	//案列,加密图片
	public  static void getVoid04() throws IOException {
		
		BufferedInputStream bis=  new BufferedInputStream(new FileInputStream("E:\\IO\\加密授课桌面背景.jpg"));
		
		
		BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream("E:\\IO\\加密11授课桌面背景.jpg"));
		int i;
		while((i=bis.read())!=-1) {
			bos.write(i^1);
		}
		
		bis.close();
		bos.close();
	}
	
	
	
	
	
	
	//优化
	//就是读取数据的时候可以进行没读个多个字节
	public  static void getVoid03() throws IOException {
		FileInputStream  fis=  new FileInputStream("E:\\IO\\授课桌面背景.jpg");
	 //由于要要展示效果，那么有读就有写
		FileOutputStream  fos=	new FileOutputStream("E:\\IO\\优化授课桌面背景.jpg");
		int v=fis.available();//读文件的大小 20g
		//-1
		//-1
		byte[] arr1=new byte[v];
		byte[] arr2=new byte[1204 * 1024];
		int i;
		while((i=fis.read(arr2))!=-1) {
			fos.write(arr2,0,i);
		}
		fos.close();
		fis.close();
	}
	
	
	//案列去取图片
	public  static void getVoid02() throws IOException {
		FileInputStream  fis=  new FileInputStream("E:\\IO\\授课桌面背景.jpg");
	 //由于要要展示效果，那么有读就有写
		FileOutputStream  fos=	new FileOutputStream("E:\\IO\\new授课桌面背景.jpg");
		
		int b;
		//
	   while((b=fis.read())!=-1) {
		      fos.write(b);
	   }
		fos.close();
		fis.close();
		
	}
	
	
	
	
	
	
	//写数据
	public  static void getVoid01() throws IOException {
		//参数一:地址.参数二:如想在后面进行追加，设置为true
		FileOutputStream  fis=	new FileOutputStream("E:\\IO\\111.txt",true);
		fis.write(98);//是一个数字，但是在文件上是 一个字节
		fis.write(95);
		fis.close();
	}
	
	
	//读数据
	public  static void getVoid() throws IOException {
		FileInputStream  fis=	new FileInputStream("E:\\IO\\新建文本文档.txt");
				int i;
				//fis.read() 二进制
				while((i=fis.read())!=-1) {
					 System.out.println(i);//码表对应的值
				}
				//流记得进行关闭
				fis.close();
	}
	
	
	
	
	

}
