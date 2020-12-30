package com.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//使用接口  线程的创建
public class Test4 {
public static void main(String[] args) {
	Student stu= new Student();
	//参数传递给Thread的构造函数
	Thread  t=new Thread(stu);
	t.start();//开启线程
}
}
