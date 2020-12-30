package com.test.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;


//字符流
public class TestJava4 {

	
	public static void main(String[] args) throws IOException, InterruptedException {
		getVoid04();
	}
			//案列:获取文件出现的字符的次数
	public  static void getVoid04() throws IOException {
		//使用的缓冲流
		BufferedReader  br=   new BufferedReader(new FileReader("E:\\IO\\111.txt"));
		//需要集合来完成
		//字符当成k,v来进行统计出现的次数
		HashMap<Character,Integer>map= 	new HashMap<>();
		//通过读取数据给集合中进添加
		//在存储中进行判断，如k存在v加1,不存在k那么v默认为1
		int c;
		while((c=br.read())!=-1){
			char ch=(char)c;
			map.put(ch,!map.containsKey(ch)?1:map.get(ch)+1);
		}

		//写出去
		BufferedWriter  bw=new BufferedWriter(new FileWriter("E:\\IO\\xxxxoooo.txt"));
		for (Character key : map.keySet()) {
			bw.write(key+"="+map.get(key)+";");
		}
		br.close();
		bw.close();
		
	}
	
	
	//获取换号
	public  static void getVoid02() throws IOException {
		LineNumberReader   br=	new LineNumberReader(new FileReader("E:\\IO\\111.txt"));
                   String lie;
                   br.setLineNumber(2);
                   while((lie=br.readLine())!=null) {
                	   System.out.println(br.getLineNumber()+":"+lie);
                	   
                   }
                   br.close();
	}
	//直接进行输出
	public  static void getVoid01() throws IOException {
		BufferedReader   br=	new BufferedReader(new FileReader("E:\\IO\\111.txt"));
		BufferedWriter  bw=new BufferedWriter(new FileWriter("E:\\IO\\ccccc.txt"));
             String lin;
             while((lin=br.readLine())!=null) {
            	 bw.write(lin);
             System.out.println(lin);
             }
		br.close();
		bw.close();
	}
	
	
	
	//待缓冲流的字符流
	public  static void getVoid() throws IOException {
		BufferedReader   br=	new BufferedReader(new FileReader("E:\\IO\\111.txt"));
		BufferedWriter  bw=new BufferedWriter(new FileWriter("E:\\IO\\1XXXX.txt"));
		int c;
		while((c=br.read())!=-1) {
			bw.write(c);
		}
		br.close();
		bw.close();
	}
	
	
	
	
	

}
