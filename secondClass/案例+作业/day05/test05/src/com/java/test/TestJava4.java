package com.java.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;


public class TestJava4 {
	public static void tets0387() {
		//Properties  
		Properties list=   new Properties();
		list.setProperty("username", "root");
		list.setProperty("password", "password");
		System.out.println(list.getProperty("username"));
	}	
	
	// Properties
	public static void tets037() {
		//Hashtable  与HashMap 容易问的
		Properties list=   new Properties();
		list.put("ASAS","三生三世");
		list.put("121112","1212");
		list.put("122212",1212);
		list.put("1233312",121);
		list.put("122222212","1212");
		System.out.println(list);
	}	
	
	
	
	
	
	
	public static void main(String[] args) {
		tets0387();
	}

}
