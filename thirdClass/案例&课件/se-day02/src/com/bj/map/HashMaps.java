package com.bj.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map 是键值对的方式来进行存储的
 *                键key  值values
 *    map和collection并列存在的 
 *    map  中的key和value 都是可以使用任何的引用数据类型
 *    map  中的key使用set来进行存放的，注意由于是set来进行存储的，
 *                那么不允许key是重复的
 *
 *
 */

public class HashMaps {

	
	public static void main(String[] args) {
		new HashMaps().testnameHashTable();
	}
	public void testnameHashTable(){
		Hashtable<String,Object> hash= new Hashtable();
		hash.put("k1", 1111);
		hash.put("k3", 333);
		hash.put("k3", 2222);
		hash.put("null", 444);//这里的null是一个字符串
		//hash.put(null,null);//不能使用null
		System.out.println(hash);
	}
	
	//  使用HashMap来进程统一字符串的次数
	public void testname(){
		String  s="QWEQWEQWEQQWEQWEQWEQWEWESDASDASDQER";
     char[]  arr=		s.toCharArray();
     HashMap<Character,Integer>  ha=  new  HashMap();
		 	for (char c : arr) {
		 		ha.put(c,!ha.containsKey(c)?1:ha.get(c)+1);
		 	}
		for (Character c : ha.keySet()) {
			System.out.println("key="+c+":"+ha.get(c));
			
		}
	}
	
	
	
	/**
	 * HashMap的遍历
	 *  
	 */
	 public void testHashMap03() {
		  HashMap<String ,Object>  map=  new HashMap();
		  map.put("1号",1);
		  map.put("4号","同学们");
		  map.put("2号",66666);
		  
		  
		  for(Entry<String ,Object> e:map.entrySet()) {
			  System.out.println( e.getKey()+"=" + e.getValue());  
		  }
		  
		  System.out.println("-================-");
		  //for遍历
		Set<String>  se= map.keySet(); 
                  for (String string : se) {
					  System.out.println(string);
				}
                  
		
		
		  
		  System.out.println("-================-");
		  
		  
		  //方式三
		  Collection<Object> keyset01=  map.values();
		    for (Object object : keyset01) {
				System.out.println(object);
			}
		    System.out.println("------aAA--------");  
		  
		  
		  //方式二
		 Set<Map.Entry<String ,Object>> set2= map.entrySet();
		Iterator<Map.Entry<String ,Object>>	iterator01= set2.iterator();
		  while(iterator01.hasNext()) {
			  Map.Entry<String ,Object> m=
					  iterator01.next();  
	          System.out.println("key:="+ m.getKey());
	          System.out.println("value:="+ m.getValue());
		  } 
			
			
		 
		  
		  
		  
		  System.out.println("------------------------");
		//方式一
		Set<String> keyset=  map.keySet();
		Iterator	iterator=	keyset.iterator();
		  while(iterator.hasNext()) {
			  String  key=(String) iterator.next();
			   System.out.println("k:"+key+"v:"+map.get(key));
		  }
		  
		/*
		 * for (int i = 0; i < map.size(); i++) { System.out.println(map.get(i)); }
		 */
		  
	 }
	
	
/**
 *HashMap常用的方法 
 */
	 public void testHashMap02() {
		  HashMap<String ,Object>  map=  new HashMap();
		  map.put("1号",1);
		  map.put("4号","同学们");
		  map.put("2号",66666);
		 Integer  i=  (Integer) map.remove("1号");
		  System.out.println(i);
		  System.out.println(map);
		  System.out.println(map.containsKey("1号"));
		  System.out.println(map.isEmpty());
		  System.out.println(map.containsValue(66666));
	 }
	
	
	
/**
 * HashMap
 */
	 public void testHashMap01() {
		  HashMap<String ,Object>  map=  new HashMap();
		  map.put("1号",1);
		  map.put("4号","同学们");
		  map.put("2号",66666);
		  map.put(null,null);
		  System.out.println(map);
	}
	
	  public void testHashMap() {
		  HashMap  map=  new HashMap();
		  map.put("1号",1);
		  map.put("2号","同学们");
		  map.put(3,"能听懂吗?");
		  map.put("4号",66666);
		  map.put(4,33333);
		  System.out.println(map);
	}
	  
	  
	
	
	

}
