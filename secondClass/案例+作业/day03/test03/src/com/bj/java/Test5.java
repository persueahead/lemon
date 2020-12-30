package com.bj.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

//LinkedList
public class Test5 {

	
	public static void main(String[] args) {
		test01();
	}
	
	
	//<> 泛型 随便一个list集合
	public static void test01()  {
		ArrayList  arr=  new ArrayList();
		arr.add(123);
		arr.add("1212312");
		arr.add(new Date());
		
		//之前是如上什么样的数据都可以进行添加
		
		Test02 [] Q= {new Test02(),new Test02()};
		//
		
		//现在 限制下添加的数据
		//但是  类型
		/*
		 * ArrayList<int> arr1= new ArrayList<Q>();
		 */
		
		
		ArrayList<Test02 >  arr2=  new ArrayList<Test02>(); 
				arr2.add(new Test02());
	}
	
	
	
}
