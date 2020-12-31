package com.bj.reflect;

public class TestReflect01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			//之前是这样玩的
		
		new TestReflect01().testname();
	}

	
	/**
	 * 实例化Class类对象方法
	 */
	public void testname() throws Exception {
		  //方法一
		/**
		 * 知道具体的类，可以使用.class获取方法
		 *    安全可靠的，程序性能高
		 */
		 Class  cl=  String.class;
		 /**
		  * 知道某个类的实例
		  * 调用该实例的时候可以使用..getClass(
		  *)获取Class对象
		  */
		 String  str=	 new String();
		 Class  c2= str.getClass();
		 /**
		  * 知道某个类的全类名名称地址
		  * 可以进行通过.forName(某个类的路径地址)
		  */
		 Class  c3=  Class.forName("java.lang.String");
		 /**
		  * 请问这三种方式获取都是同一个对象吗
		  */
		 System.out.println(cl==c2);
		 System.out.println(c3==c2);
		 System.out.println(c3==cl);
	}
}
