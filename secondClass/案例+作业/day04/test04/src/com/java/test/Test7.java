package com.java.test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;


///LinkedHashSet
public class Test7 {

	//LinkedHashSet
	public static void testName03(){
		LinkedHashSet<String>  list= new LinkedHashSet();
		list.add("bbbb");
		list.add("aaaa");
		list.add("cccc");
		list.add("cccc");
		System.out.println(list);
	}
	
	
	
	public static void main(String[] args) {
		testName03();
		
	}
}
