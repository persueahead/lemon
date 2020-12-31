package com.bj.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class TestFileInAdnOut {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          new TestFileInAdnOut().testname03_1();
	}
	
	//优化下
	public void testname03_1() throws Exception {
		FileInputStream  in=  new FileInputStream("D:\\xxx\\xxxx.jpg");
		FileOutputStream  out=new FileOutputStream("D:\\xxx\\xxxx修改之后的.jpg");
		in.available();//不建议使用
		byte[] b=	  new byte[1024*1024];//2G
		
		int  i;
		while((i=in.read(b))!=-1) {
			out.write(b,0,i);
		}
		in.close();
		out.close();
	}
	
	
	//案列拷贝图片
	public void testname03() throws Exception {
		FileInputStream  in=  new FileInputStream("D:\\xxx\\xxxx.jpg");
		FileOutputStream  out=new FileOutputStream("D:\\xxx\\xxxx修改之后的.jpg");
		int  i;
		while((i=in.read())!=-1) {
			out.write(i);
		}
		in.close();
		out.close();
	}
	
	//
	
	
	
	//字节流的读数据
		public void testname01() throws IOException{
			FileOutputStream out=
					new FileOutputStream("D:\\xxx\\oo\\XXXOO.txt");
			out.write(12);
			out.write(56);
			out.write(66);
			out.write(18);
			out.close();
		}
	//字节流的读数据
	public void testname() throws IOException{
		FileInputStream intput= 
				new FileInputStream("D:\\xxx\\oo\\XXXOO.txt");
		byte[] b=  new byte[1024*1024];
	       int i;
	       while((i=intput.read(b))!=-1) {
	    	   System.out.println(new String(b,0,i));//码表的值
	       }
	       intput.close();
	}

}
