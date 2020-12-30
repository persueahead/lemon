package com.java.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class TestJava2 {
	// TreeMap
	public static void tets037() {
		TreeMap<Student,Integer>  list=   new TreeMap<>();
		list.put(new Student("B",125),345);
		list.put(new Student("B",126),346);
		list.put(new Student("C",127),23);
		list.put(new Student("C",128),456);
		System.out.println(list);
	}	
	
	
	
	
	
	
	public static void main(String[] args) {
		tets037();
	}

}
