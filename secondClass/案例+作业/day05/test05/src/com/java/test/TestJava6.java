package com.java.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class TestJava6 {

	/*
	 * 3、一个集合中存储了无序并且重复的字符串,定义一个方法,让其有序，而且还不能去除重复
     如下集合:输出的结果为:[aa, aa, aaa, aaaa, bbbb, ddd, ddd]
	ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        list.add("ddd");
        list.add("ddd");
        list.add("bbbb");
        list.add("aa");
        list.add("aa");
	 * 
	 * */
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        list.add("ddd");
        list.add("ddd");
        list.add("bbbb");
        list.add("aa");
        list.add("aa");
        
        TreeSet  ts=new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				    int  i=o1.compareTo(o2);
				return i==0?1:i;
			}
        });
		
        ts.addAll(list);
        list.clear();
        list.addAll(ts);
        System.out.println(list);
		
	}
	
	


}
