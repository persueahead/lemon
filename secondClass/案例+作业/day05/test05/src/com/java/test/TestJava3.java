package com.java.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class TestJava3 {
	// Hashtable
	public static void tets037() {
		//Hashtable  与HashMap 容易问的
		Hashtable<String,String>  list=   new Hashtable<>();
		list.put("ASAS","三生三世");
		list.put("121112","1212");
		list.put("122212","1212");
		list.put("1233312","1212");
		list.put("122222212","1212");
		System.out.println(list);

		System.out.println("------------------");
		HashMap<String,String>  HashtMap=   new HashMap<>();
		HashtMap.put(null,null);
		HashtMap.put("1212","1212");
		HashtMap.put("121211","1212");
		HashtMap.put("12121111","1212");
		HashtMap.put("121211111","1212");
		System.out.println(HashtMap);
		
		
	}	
	
	
	
	
	
	
	public static void main(String[] args) {
		tets037();
	}

}
