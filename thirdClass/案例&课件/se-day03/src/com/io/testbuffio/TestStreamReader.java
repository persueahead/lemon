package com.io.testbuffio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestStreamReader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       new TestStreamReader().testname01();
	}
	
	public void testname01() throws Exception {
		BufferedReader   streamReader 
		=new BufferedReader(
		new InputStreamReader(
				new FileInputStream("D:\\xxx\\oo\\拷贝1.txt"),"UTF-8"));
		
		BufferedWriter   out		=  new BufferedWriter(
		new OutputStreamWriter(
				new FileOutputStream("D:\\xxx\\oo\\拷贝XXXXXX.txt"),"UTF-8"));
		int i;
		while((i=streamReader.read())!=-1){
			out.write(i);
		}
		streamReader.close();
		out.close();
	}
	
	public void testname() throws Exception {
		InputStreamReader   streamReader 
		=new InputStreamReader(new FileInputStream("D:\\xxx\\oo\\拷贝1.txt"),"UTF-8");
		OutputStreamWriter   out		=
		new OutputStreamWriter(new FileOutputStream("D:\\xxx\\oo\\拷贝22222221.txt"),"UTF-8");
		int i;
		while((i=streamReader.read())!=-1){
			out.write(i);
		}
		streamReader.close();
		out.close();
	}
	

}
