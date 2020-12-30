package com.java.test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;


///HashSet
public class Test5 {

	public void testName01(){
		HashSet  hst=    new HashSet();
		hst.add("1");
		hst.add("2");
		hst.add("3");
		hst.add("3");
		hst.add("3");
		hst.add(null);
		hst.add("不要脸");
		//注意不能调用ListIterator因为是系列表迭代器
		Iterator it= hst.iterator();
		
		
		
	}
	
	public static void testName(){
		HashSet  hst=    new HashSet();
		hst.add("1");
		hst.add("2");
		hst.add("2");
		hst.add("2");
		hst.add(null);
		hst.add("不要脸");
		hst.add("不要脸");
		hst.add("不要脸");
		System.err.println(hst);
		
	}
	//HashSet传入自定义对象
	public static void testName03(){
		HashSet<Users>  hst=    new HashSet();
		hst.add(new Users("小张",12));
		hst.add(new Users("小张",12));
		hst.add(new Users("小张",12));
		
		Iterator it=	hst.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	
	
	
	public static void main(String[] args) {
		testName03();
		
	}
}
