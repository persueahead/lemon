package com.java.test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.TreeSet;


///TreeSet
public class Test8 {

	//TreeSet
	public static void testName03(){
		TreeSet<Integer>  list= new TreeSet();
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(4);
		list.add(4);
		System.out.println(list);
	}
	
	
	
	public static void main(String[] args) {
		testName03();
		
	}
}
