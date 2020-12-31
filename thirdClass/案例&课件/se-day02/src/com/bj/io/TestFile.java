package com.bj.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class TestFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
          new TestFile().testname06();
	}
	
	//查询
	public void testname06() throws IOException{
		File  file=  new File("D:\\xxx");
		//获取所有的名称
		String [] s=
				file.list();
		for (String string : s) {
			System.out.println(string);
		}
		System.out.println("---------------");
		//获取文件
		File[]  files=file.listFiles();
		for (File file2 : files) {
			System.out.println(file2);
		}
		
		System.out.println("获取绝对的路径地址:"+file.getAbsolutePath());
		System.out.println("获取存入的路径地址:"+file.getPath());
		System.out.println("获取文件名:"+file.getName());
		System.out.println("获取长度:"+file.length());
		//获取时间
		System.out.println("获取时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(file.lastModified()));
		
	}
	
	
	//判断目录和文件
	public void testname05() throws IOException{
		File  file=  new File("D:\\xxx\\oo");
		System.out.println("判断当前目录是否是目录"+file.isDirectory());
		System.out.println("判断当前目录是否是文件"+file.isFile());
		System.out.println("判断当前目录是否有隐藏的文件"+file.isHidden());
	}
	
	
	//修改文件名
	public void testname04_1() throws IOException{
		File  file1=  new File("D:\\xxx\\oo\\OOOXXXX.xls");
		File  file=  new File("D:\\xxx\\text.xls");
		System.out.println(file1.renameTo(file));
	}
	public void testname04() throws IOException{
		File  file=  new File("D:\\xxx\\oo\\text.xls");
		File  file1=  new File("D:\\xxx\\oo\\OOOXXXX.xls");
        System.out.println(file.renameTo(file1));
	}
	
	//删除文件
	public void testname03() throws IOException{
		File  file=  new File("D:\\xxx\\oo");
		file.delete();
	}
	
	//删除文件
	public void testname02() throws IOException{
		File  file=  new File("D:\\xxx\\oo\\text.xls");
		file.delete();
	}
	
	//创建文件的
	public void testname01() throws IOException{
		File  file=  new File("D:\\xxx\\oo\\text.xls");
		if(!file.exists()) {
			file.createNewFile();
		}
	}
	//创建目录的地址
	public void testname(){
		File  file=  new File("D:\\xxx\\oo");
		if(!file.exists()) {
			file.mkdirs();
		}
	}

}
