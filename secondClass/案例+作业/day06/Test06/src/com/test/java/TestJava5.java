package com.test.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;


//转换流
public class TestJava5 {

	
	public static void main(String[] args) throws IOException, InterruptedException {
		getVoid02();
	
	}
	
	// 数据流
	public  static void getVoid02() throws IOException {
		// 数据流
		DataOutputStream  DOS=  new DataOutputStream(new FileOutputStream("E:\\IO\\SSSSSS.txt"));
		DOS.writeUTF("同学们里面好要的阿达阿道夫af");//放入字符串
		DOS.writeInt(12);//数字
		DOS.close();
		DataInputStream  dis=	new DataInputStream(new FileInputStream("E:\\IO\\SSSSSS.txt"));
		 System.out.println(dis.readUTF());//获取字符串
		 System.out.println(dis.readInt());
		
	}
	
	//缓冲流进行的嵌套
		public  static void getVoid01() throws IOException {
			//缓冲流进行的嵌套
			BufferedReader  br=	new BufferedReader(
			new InputStreamReader(
					new FileInputStream("E:\\IO\\111.txt")));
			
			BufferedWriter  bw=	new BufferedWriter(
		  new OutputStreamWriter(
				  new FileOutputStream("E:\\\\IO\\\\papapapa.txt")));
			int c;
			while((c=br.read())!=-1) {
				bw.write(c);
			}
			br.close();
			bw.close();
		}
	
	//转换流
	public  static void getVoid() throws IOException {
		//转换流
		InputStreamReader  isr=  new InputStreamReader(new FileInputStream("E:\\IO\\111.txt"));
		
		OutputStreamWriter  osw=new OutputStreamWriter(new FileOutputStream("E:\\\\IO\\\\papapapa.txt"));
		int c;
		while((c=isr.read())!=-1) {
			osw.write(c);
		}
		isr.close();
		osw.close();
	}
	
}
