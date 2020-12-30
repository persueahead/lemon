package com.java.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;


public class TestJava5 {

	
	public static void main(String[] args) {
		tets044();
		
	}
	
	//获取文件的名称
	public static void tets044() {
		File  f1=new File("D:\\1234");
		File[] st=f1.listFiles();
		for (File file : st) {//获取的是File对象
			System.out.println(file);
		}
		System.out.println("绝对路径+"+f1.getAbsolutePath());
		System.out.println("径名转换为一个路径名字符串。+"+f1.getPath());
		System.out.println("获取名称+"+f1.getName());
		System.out.println("长度+"+f1.length());
		System.out.println("时间"+f1.lastModified());
	}
	
	
	//获取文件夹名
	public static void tets043() {
		File  f1=new File("D:\\1234");
	String [] ST=	f1.list();//获取文件名称
	 for (String string : ST) {
		System.out.println(string);
	}
	}
			//修改文件夹
		public static void tets042() {
			File  f1=new File("D:\\1234\\新建文件夹");
			System.out.println(f1.isDirectory());
			File  f2=new File("D:\\1234\\新建文件夹\\修改之222222后.txt");
			System.out.println(f2.isFile());
			System.out.println(f2.isHidden());
		}
		
		
		//修改文件夹
	public static void tets041() {
		File  f1=new File("D:\\1234\\新建文件夹\\修改之222222后.txt");
		File  f2=new File("D:\\1234\\修改之后.txt");
		System.out.println(f2.renameTo(f1));
	}	
	public static void tets040() {
		File  f1=new File("D:\\1234\\新建文件夹\\新建文本文档.txt");
		File  f2=new File("D:\\1234\\新建文件夹\\修改之后.txt");
		System.out.println(f1.renameTo(f2));
	}	
	
	
	//删除空文件夹
	public static void tets039() {
		File  f=new File("D:\\1234");
		System.out.println(f.delete());
	}	
	
	//删除文件
	public static void tets038() {
		File  f=new File("D:\\1234\\1234444\\xxx.txt");
		System.out.println(f.delete());
	}	
	
	
	public static void tets037() throws IOException {
		//创建文件夹
		File f=  new File("D:\\1234\\1234444");	
		//需要进行判断"D:\\1234"是否存在
     	if(!f.exists()) {//测试此抽象路径名表示的文件或目录是否存在。
     		f.mkdirs();
     		System.out.println("------------");
     	}
     	
    	//创建文件
     	File f1=  new File(f,"xxx.txt");	
		//需要进行判断"D:\\1234"是否存在
     	if(!f1.exists()) {//测试此抽象路径名表示的文件或目录是否存在。
     		f1.createNewFile();
     		System.out.println("------------");
     	}
	}	
	
	
	
	
	


}
