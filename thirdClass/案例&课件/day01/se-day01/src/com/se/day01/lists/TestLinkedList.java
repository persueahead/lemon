package com.se.day01.lists;

import java.util.LinkedList;

/**
 * LinkedList
 */
public class TestLinkedList {

	public static void main(String[] args) {
		new TestLinkedList().testname();
	}
	
	
	public void testname(){
		LinkedList<Integer>  list=   new LinkedList();
		list.add(12);
		list.add(132);
		list.add(1245);
		
	for (Object object : list) {
		System.out.println(object);
	}
		
		
	}
	
}
