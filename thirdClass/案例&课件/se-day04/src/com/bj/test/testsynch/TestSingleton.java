package com.bj.test.testsynch;

/**
 * 饿汉式
 */
class Singleton {
	//私有的构造方法
	private  Singleton() {
	}
	//创建本身的对象
	private  static  Singleton S=new Singleton();
	//提供公共访问对象的方法
	public static Singleton  getSingleton() {
		System.out.println("---提供公共访问对象的方法---");
		return S;
	}
}

public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1=	Singleton.getSingleton();
		Singleton s2=	Singleton.getSingleton();
		Singleton s3=	Singleton.getSingleton();
		System.out.println(s1==s2);
		System.out.println(s2==s3);
		System.out.println(s3==s1);
	}
}
