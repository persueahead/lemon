package com.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//对象流
//对象的序列化
public class Test01 {

	//对象流反序列化
	public static void getVoid01() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("----------------------");
	     //读取数据
		ObjectInputStream  ois=new ObjectInputStream(new FileInputStream("E:\\IO\\111.txt"));
		Users  u=(Users) ois.readObject();
		System.out.println(u);  
	}
	//对象流序列化
	public static void getVoid() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream oos=  new ObjectOutputStream(new FileOutputStream("E:\\IO\\111.txt"));
		Users us=  new Users("小张",22);
		oos.writeObject(us);
		oos.flush();
		oos.close();
	}
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		getVoid01();
	}

}
