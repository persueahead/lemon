package com.java.test;

//线程的常用的方法
public class JavaTest4 {
	
	
	public static void main(String[] args) {
		Singleton  s1=Singleton.getInstance();
		Singleton  s2=Singleton.getInstance();
		System.out.println(s1==s2);
		System.out.println("-------------------");
		
		Singleton1  sS1=Singleton1.getInstance();
		Singleton1  sS2=Singleton1.getInstance();
		System.out.println(sS1==sS2);
		System.out.println("-------------------");
		
		
		
	}
	
	
	
	
	
	
	

}

//懒汉
class Singleton1{
	  //私有的构造方法,
	private Singleton1() {
	}
	//生明一个对象
	private  static Singleton1 s;
	//对外提供公开的访问方式
	  public static Singleton1  getInstance() {
		  if(s==null) {
			  s=new Singleton1();
		  }
		  return s;
	  }
}
//饿汉
class Singleton{
	  //私有的构造方法,
	private Singleton() {
	}
	//创建本类对象
	private  static Singleton s=new Singleton();
	//对外提供公开的访问方式
	  public static Singleton  getInstance() {
		  return s;
	  }
}