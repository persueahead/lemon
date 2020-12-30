package com.java.test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test01 {
  
	
	
	public static void main(String[] args) {
		ArrayList  arr=   new ArrayList();
		arr.add(1);
		arr.add(11);
		arr.add(12);
		arr.add(13);
		arr.add(14);
		
		
		
		
		Iterator  it=	arr.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		for (Object object : arr) {
			System.out.println(object);
		}
		
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		
		
		
	}
	
}

