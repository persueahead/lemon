package com.bj;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassStudent {

	
	
	//通过反射获取该类中的构造函数
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
       //获取Student实例
	Class stu=	Student.class;
	Constructor  constructor=	stu.getConstructor(String.class,int.class);
	Student    student =(Student)constructor.newInstance("陈二狗",3);
	System.out.println(student);
	System.out.println("=======================");
	Constructor  constructor1=	stu.getConstructor();
	Student    student1 =(Student)constructor1.newInstance();
	System.out.println(student1);
	System.out.println("=======================");
	Constructor  constructor2=	stu.getConstructor(String.class,int.class,String.class,int.class);
	Student    student2 =(Student)constructor2.newInstance("陈二狗",3,"陈二狗",3);
	System.out.println(student2);

	}

}
