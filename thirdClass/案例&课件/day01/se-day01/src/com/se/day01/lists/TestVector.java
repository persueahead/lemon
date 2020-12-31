package com.se.day01.lists;


import java.util.Vector;


public class TestVector {

	public static void main(String[] args) {
		new TestVector().testName();
	}
	public void testName(){
		Vector  vec= new Vector();
		vec.add(111);
		vec.add(121);
		vec.add(131);
		vec.add(111);
	
		  for (int i = 0; i < vec.size(); i++) {
			  System.out.println(vec.get(i));
		}
		  
	  
	}
	
	

}
