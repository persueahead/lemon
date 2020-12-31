package com.io.testbuffio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.HashMap;

public class TestReder {

	  public static void main(String[] args) throws Exception {
		  new TestReder().testname04();
	}
	/**
	 * 案列  ：
   使用IO流获取一个文件中出现字符的次数
	 * @throws Exception
	 */
	  public void testname05() throws Exception {
		  BufferedReader  reder=     new BufferedReader(new FileReader("D:\\xxx\\oo\\拷贝1.txt"));
		  HashMap<Character,Integer>  map= new HashMap<>();
	
		    int i;
		    while((i=reder.read())!=-1) {
		    	map.put((char)i,
		    			!map.containsKey((char)i)?1:map.get((char)i)+1
		    			);
		    }
		    reder.close();
		    //写输入到某个文件
		    BufferedWriter  wrter=  new BufferedWriter(new FileWriter("D:\\xxx\\oo\\统计后的数据.txt"));
			  for (Character key : map.keySet()) {
				  wrter.write(key+":"+map.get(key));
				  wrter.newLine();
				}
			  wrter.flush();
			  wrter.close();
	  }
	  
	  
	  public void testname04() throws Exception {
		  LineNumberReader line= new LineNumberReader(new FileReader("D:\\xxx\\oo\\拷贝1.txt"));
		   String str;
		   //line.setLineNumber(100);
		     while((str=line.readLine())!=null){
		    	   System.out.println(line.getLineNumber()+":"+str);
		     }
		     line.close();
	}
	  
	  
	  /**
	   * 缓冲流拷贝文件
	   */
	  public void testname03() throws Exception {
		  BufferedReader  reader= new BufferedReader(new FileReader("D:\\xxx\\oo\\xxxoo.txt"));
		  BufferedWriter  file=  new BufferedWriter(new FileWriter("D:\\xxx\\oo\\拷贝1.txt"));
		  
		   int i;
		   while((i=reader.read())!=-1) {
			   file.write(i);
			   file.newLine();//换行的
		   }
		   file.flush();
		   file.close();
		   reader.close(); 
	}
	  
	  /**
	   * 字符流拷贝文件
	   */
	  public void testname02() throws Exception {
		  FileReader  reader=new FileReader("D:\\xxx\\oo\\xxxoo.txt");
		  FileWriter  file=  new FileWriter("D:\\xxx\\oo\\拷贝.txt");
		  char[] c=   new char[1024];
		   int i;
		   while((i=reader.read(c))!=-1) {
			   file.write(c, 0, i);
		   }
		   file.flush();
		   file.close();
		   reader.close(); 
	}
	  
	  /**
	   *使用字符流记性写中文 
	   */
	  public void testname01() throws Exception {
		  FileWriter  file=  new FileWriter("D:\\xxx\\oo\\qew.txt");
		  file.write("三阶段");
		  file.write("三阶段");
		  file.write(97);
		  file.flush();
		  file.close();
	  }
	  
	  /**
	   * 使用字符流进行读取字符
	   */
	  public void testname() throws Exception {
		  FileReader  reader=new FileReader("D:\\xxx\\oo\\xxxoo.txt");
		   int i;
		   while((i=reader.read())!=-1) {
			   System.out.println((char)i);
		   }
		   reader.close();
	}
	  
}
