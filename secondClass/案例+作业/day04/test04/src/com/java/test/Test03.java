package com.java.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

//ListIterator逆向遍历
public class Test03 {

	
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		ListIterator  aa=list.listIterator();
		while(aa.hasNext()) {
			System.out.println(aa.next());
		}
		System.out.println("-------------------------------");
			aa.add("5");
		while(aa.hasPrevious()) {
				System.out.println(aa.previous());
		}
	}
}
