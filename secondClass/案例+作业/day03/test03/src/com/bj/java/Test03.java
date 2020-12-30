package com.bj.java;

import java.util.LinkedList;

//LinkedList
public class Test03 {

	
	public static void main(String[] args) {
		test01();
	}
	
	
	//
	public static void test01()  {
		LinkedList  list=  new LinkedList();
		list.add("123123");
		list.add("123123");
		list.add(123123);
		list.add("123123");
		
		for (Object object : list) {
			System.out.println(object);
		}
		System.out.println("--------------------------");
		
		System.out.println("-getFirst--"+list.getFirst());
		System.out.println("-getLast--"+list.getLast());
		System.out.println("--------------------------");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	
	
}
