package com.test.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//字符流
public class TestJava3 {

	
	public static void main(String[] args) throws IOException, InterruptedException {
		getVoid04();
	}
	
	//可以使用数组的方式来
	public  static void getVoid04() throws IOException {
		FileReader  fr= new FileReader("E:\\IO\\111.txt");
		FileWriter  fw=new FileWriter("E:\\IO\\拷贝.txt");
		int i;
		char[] c=new char[1024];
		while((i=fr.read(c))!=-1) {
			fw.write(c,0,i);
		}
		fr.close();
		fw.close();
	}
	
	//使用字符流拷贝图片可以吗？=不能进行拷贝的()
	public  static void getVoid03() throws IOException {
		FileReader  fr= new FileReader("E:\\IO\\new授课桌面背景.jpg");
		FileWriter  fw=new FileWriter("E:\\IO\\1111111111111授课桌面背景.jpg");
		int i;
		while((i=fr.read())!=-1) {
			fw.write(i);
		}
		fr.close();
		fw.close();
	}
	//使用字符流激励性拷贝
	public  static void getVoid02() throws IOException {
		FileReader  fr= new FileReader("E:\\IO\\111.txt");
		FileWriter  fw=new FileWriter("E:\\IO\\拷贝.txt");
		int i;
		while((i=fr.read())!=-1) {
			fw.write(i);
		}
		fr.close();
		fw.close();
	}
	
	
	
	
	//写
	public  static void getVoid01() throws IOException {
		//参数一地址，参数为时候在后面进行追加
		FileWriter  fw=new FileWriter("E:\\IO\\111.txt",true);
		fw.write("柠檬柠檬柠檬柠檬柠檬柠檬柠檬柠檬");
		fw.close();
	}
	
	
	//读
	public  static void getVoid() throws IOException {
		FileReader frd= new FileReader("E:\\IO\\111.txt");
		  int c;
		  while((c=frd.read())!=-1) {
			   System.out.println((char)c);
		  }
		frd.close();
	}
	
	
	
	
	

}
