package com.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//线程的创建
public class Test3 {
public static void main(String[] args) {
	//创建对象
	Student2  stu=   new Student2();
		stu.start();//开启线程
}
}
