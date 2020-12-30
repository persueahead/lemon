package com.java.test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.TreeSet;


///TreeSet
public class Test9 {

	
	
	
	//TreeSet
	//目前是按照默认的方式来进行完成
	//怎么进行使用到自定义
	public static void testName03(){
		TreeSet<String>  list= new TreeSet(new Compareby());
		list.add("qqqqqq");
		list.add("eeeeeeeeeeeeeeeeeeeeeee");
		list.add("eee");
		list.add("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		System.out.println(list);
	}
	
	
	
	public static void main(String[] args) {
		testName03();
		
	}
}

//自定义的
class Compareby  implements Comparator<String>{
	//o1大于o2 返回正确 ，相等 返回 0  负整数  表示 o1小于o2
	@Override
	public int compare(String o1, String o2) {
		
		int i=	 o1.length()-o2.length();//主要的按照长度来进行判断条件
		
		return i==0 ? o1.compareTo(o2):i;//通过内容来进行对比次要的条件
	}
}