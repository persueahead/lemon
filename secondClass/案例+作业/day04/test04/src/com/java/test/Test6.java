package com.java.test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;


///HashSet
public class Test6 {

	//HashSet传入自定义对象
	public static void testName03(){
		HashSet<Student>  hst=    new HashSet();
		hst.add(new Student("小张"));
		hst.add(new Student("小张"));
		hst.add(new Student("小张"));
		hst.add(new Student("小张"));
		
		Iterator it=	hst.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	
	
	
	public static void main(String[] args) {
		testName03();
		
	}
}
