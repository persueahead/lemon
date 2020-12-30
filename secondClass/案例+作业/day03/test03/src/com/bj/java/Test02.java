package com.bj.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test02 {

	public void testname() throws Exception {
		  Object[] I={"xx",1122,new Date()}; 
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		test06_1();
	}

	
    //数组转换成集合
	public  static void test06_1() throws Exception {
		  Integer [] i= {1,2,3,4,5};
		 List<Integer>  list= Arrays.asList(i);
		   System.out.println(list);
		     list.toArray();
	}
	
	public  static void test06() throws Exception {
		ArrayList  arr= new ArrayList();
		arr.add(123);//添加数据 
		arr.add("0000000");//添加数据
		arr.add(new Date());
		arr.toArray();
	 
	}
	
	//常用API的方法
	public  static void test05() throws Exception {
		ArrayList  arr= new ArrayList();
		arr.add(123);//添加数据 
		arr.add("0000000");//添加数据
		arr.add(new Date());
		//arr.clear();//清除
		System.out.println("arr.get(2)"+arr.get(2));
		arr.set(2, "好爽");
		System.out.println("arr.get(2)"+arr.get(2));
		System.out.println("arr.remove(0)"+arr.remove(0));//删除
		System.out.println("arr.get(0)"+arr.get(0));
		System.out.println(arr.isEmpty());//果此列表中没有元素，则返回 true
		System.out.println(arr.indexOf("QWEQWEQW"));
		System.out.println(arr.size());//返回此列表中的元素数
	 
	}
	
	//遍历二
	public  static void test04() throws Exception {
		ArrayList  arr= new ArrayList();
		arr.add(123);//添加数据
		arr.add("0000000");//添加数据
		arr.add(new Date());
		System.out.println(arr.size());//返回此列表中的元素数
	  for (Object object : arr) {
		  System.out.println(object);
	}
	}
	
	//遍历
	public  static void test03() throws Exception {
		ArrayList  arr= new ArrayList();
		arr.add(123);//添加数据
		arr.add("0000000");//添加数据
		arr.add(new Date());
		System.out.println(arr.size());//返回此列表中的元素数
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		
	}
	
	//arryList
	public  static void test02() throws Exception {
		ArrayList  arr= new ArrayList();
		arr.add(123);//添加数据
		arr.add("0000000");//添加数据
		arr.add(new Date());
		
		ArrayList  arr1= new ArrayList();
		arr1.add(123123);//添加数据
		arr1.add("000000011111");//添加数据
		
		arr.addAll(arr1);
		
		
	}
	
	//arryList
	public  static void test01() throws Exception {
		ArrayList  arr= new ArrayList();
		arr.add(123);//添加数据
		arr.add("0000000");//添加数据
		arr.add(new Date());
		//0000000
		 System.out.println(arr.get(1));   //为什么是这样?  
		arr.add(1,"陈不要脸,你帅");
		//取数据?回想数组怎么去,可以通过下标来进行去取值
		//陈不要脸,你帅
		 System.out.println(arr.get(1));   //为什么是这样?  
		 
		
		
	}
	
	

}
