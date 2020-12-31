package com.io.testbuffio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.io.pojo.Person;
import com.io.pojo.Student;

public class TestObjectStream {

	
	public static void main(String[] args) throws Exception {
		new TestObjectStream().testname01();
	}
	
	public void testname01() throws Exception {
		//反序列化
		ObjectInputStream  in=
				new ObjectInputStream(new FileInputStream("D:\\xxx\\oo\\person.txt"));
		Person  p=(Person) in.readObject();
		System.out.println(p);
	}
	public void testname() throws Exception {
		//序列化
		ObjectOutputStream
		out=
		new ObjectOutputStream(new FileOutputStream("D:\\xxx\\oo\\person.txt"));
		Person  p=new Person("小张",1231);
		Student st=   new Student("同学们",23);
		p.setStudent(st);
		
		
		out.writeObject(p);
		out.flush();
		out.close();
	}
}
