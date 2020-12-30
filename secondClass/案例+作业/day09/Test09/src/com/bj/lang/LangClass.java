package com.bj.lang;

import com.bj.Student;

public class LangClass {
	public void name3() throws ClassNotFoundException {
		 Class czz=	Class.forName("java.lang.String");
		 Class czz1=	String.class;
		 String  stu=	  new String();
		Class  czzString=stu.getClass();
			System.out.println(czz==czz1);
			System.out.println(czz1==czzString);
			System.out.println(czzString==czz);
		}
	
	//	3)知道一个类的全类名,该类在类路径下可以通过Class类的静态方法
	  //forName()获取
	public void name2() throws ClassNotFoundException {
	 Class czz=	Class.forName("java.lang.String");
	}
	//	2)知道某个类的实例,调用该类实例的getClass方法获取Class对象
	public static void name1() {
		Student  stu=	  new Student();
		Class  czz=stu.getClass();
		}
	
	/**
	 * 	2。创建Class类对象3种
	  1）知道那个类,通过类的class属性获取该方法
	      安全可靠,性能高
	 */
	//实例化Class类对象的方法
	public static void name() {

	 Class czz=	String.class;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
 // new String();
		try {
		new LangClass().name3();
			System.out.println("----------------");
			String S1=	new String();
			String S2=	new String();
			String S3=	new String();
			System.out.println(S1==S2);
			System.out.println(S2==S3);
			System.out.println(S3==S1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
