package com.java.test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeSet;


///map
public class Test11 {

	
	
	//map
	public static void testName04(){
		new HashSet();
		Map  nap= new HashMap();
		nap.put("学号1-k",1112);
	}
	//进行约束k-V的类型
	public static void testName05(){
		//<String ,String>类型不能是基本数据类型
		Map<String ,String>  nap= new HashMap<String ,String>();
		nap.put("学号1-k","123123");
	}
	
	
	public static void testName06(){
		//<String ,String>类型不能是基本数据类型
		HashMap<String ,String>  nap= new HashMap<String ,String>();
		nap.put("学号1-k1","111111111");
		nap.put("学号1-k1","2222221");
		nap.put(null,"同学们1");
		nap.put("学号3-k1",null);
		System.out.println(nap);
	}
	public static void main(String[] args) {
		testName06();
		
	}
}
