package com.java.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class TestJava {
	// TreeMap
	public static void tets037() {
		TreeMap<Integer,Integer>  list=   new TreeMap<>();
		list.put(1,123);
		list.put(3,34);
		list.put(4,345);
		list.put(5,346);
		list.put(6,23);
		list.put(0,456);
		System.out.println(list);
	}	
	//LinkedHashMap
	public static void tets036() {
		LinkedHashMap<String,Integer>  list=   new LinkedHashMap<>();
		list.put("asdas",123);
		list.put("asd122 ",34);
		list.put("asdasd引江济淮",345);
		list.put("御景园奖金",346);
		list.put("ty65 好他换了个",23);
		list.put("456u5hrghr",456);
		
		System.out.println(list);
		System.out.println("---------------------------");
	HashMap<String,Integer>  MA=   new HashMap<>();
	MA.put("asdas",123);
	MA.put("asd122 ",34);
	MA.put("asdasd引江济淮",345);
	MA.put("御景园奖金",346);
	MA.put("ty65 好他换了个",23);
	MA.put("456u5hrghr",456);
		System.out.println(MA);
	}
	
	//使用Hashmap统计字母出现次数
	public static void tets035() {
	    String s="ASDASDDDDDDDDASDASDASDAAAAAA"; 
	  char[]  c=	s.toCharArray();
	      HashMap<Character, Integer>  hs=
	      new HashMap<>();
			for (char d : c) {
				hs.put(d,!hs.containsKey(d)?1:hs.get(d)+1);
				}
			      
			 for (Character d :hs.keySet()) {
				System.out.println(d+":"+hs.get(d));
			}
	}
	
	
	//hashMap遍历方式三
	public static void tets034() {
	  HashMap<String,String> has= new HashMap();
	  	has.put("姓名", "小张");
		has.put("姓名1", "小张2");
		has.put("姓名2", "小张3");
		has.put("姓名3", "小张4");
		
		for (Entry<String,String> iterable_element : has.entrySet()) {
			  System.out.println(iterable_element.getKey());
			  System.out.println(iterable_element.getValue());
		}
		
		}

	//hashMap遍历方式三
		public static void tets033() {
		  HashMap<String,String> has= new HashMap();
		  	has.put("姓名", "小张");
			has.put("姓名1", "小张2");
			has.put("姓名2", "小张3");
			has.put("姓名3", "小张4");
			
			for (String iterable_element : has.keySet()) {
				  System.out.println(has.get(iterable_element));
			}
			
			}
	
	
	//hashMap遍历方式二
	public static void tets02() {
	  HashMap<String,String> has= new HashMap();
	  	has.put("姓名", "小张");
		has.put("姓名1", "小张2");
		has.put("姓名2", "小张3");
		has.put("姓名3", "小张4");
		
	  //使用的是Map内部接口,将k-v进行封装了Entry对象,并存入找set集合中
		Set<Map.Entry<String,String>> enset=has.entrySet();
		Iterator<Map.Entry<String,String>> it=	enset.iterator();
		  //获取每一个entry
		    while(it.hasNext()) {
		    	  //获取entry对象
		    Map.Entry<String,String> ms=	it.next();
		      //获取K 与V
		      String key=ms.getKey();
		      String va=ms.getValue();
		      System.out.println(key+":"+va);
		    }
		
		
		
		
		
	}
	//hashMap遍历方式一
	public static void tets01() {
	  HashMap<String,String> has= new HashMap();
	  	has.put("姓名", "小张");
		has.put("姓名1", "小张2");
		has.put("姓名2", "小张3");
		has.put("姓名3", "小张4");
		//获取所以的键
     Set<String> st=has.keySet();
     Iterator<String> i=   st.iterator();
		while (i.hasNext()) {//判断当前是否有元素
			//获取对应的key 
			String key=i.next();
			 //根据Key获取Value
			 String va=  has.get(key);
			System.out.println(key+"："+va);
		}
	}
	
	
	
	//HashMap
	public static void tets() {
		HashMap<String ,String>  has=  new HashMap<String,String>();
		has.put("姓名", "小张");
		has.put("姓名1", "小张2");
		has.put("姓名2", "小张3");
		has.put("姓名3", "小张4");
		//返回values值
		System.out.println(has.remove("姓名"));
		System.out.println(has.containsKey("姓名1"));
		System.out.println(has.containsValue("小张3"));
	}
	
	
	
	public static void main(String[] args) {
		tets037();
	}

}
