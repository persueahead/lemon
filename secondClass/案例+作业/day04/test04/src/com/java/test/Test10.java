package com.java.test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.TreeSet;


///TreeSet
public class Test10 {

	
	
	
	//TreeSet
	//目前是按照默认的方式来进行完成
	//怎么进行使用到自定义
	public static void testName03(){
		TreeSet<Users>  list= new TreeSet();
		list.add(new Users("aaaa",23));
		list.add(new Users("aaaa",131));
		list.add(new Users("aaa",12));
		list.add(new Users("aa",10));
		list.add(new Users("bb",1));
		
		System.out.println(list);
	}
	public static void testName04(){
		TreeSet  list= new TreeSet();
		list.add(1111);
		list.add(222);
		System.out.println(list);
	}
	
	
	public static void main(String[] args) {
		testName04();
		
	}
}
