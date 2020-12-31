package com.se.day01.lists;

import java.util.HashSet;
import java.util.Iterator;

import com.se.day01.pojo.Users;

public class TestHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestHashSet().testname01();
	}

	//案列去除重复的对象
	public void testname01(){
		
		HashSet<Users> set= new HashSet();
		set.add(new Users(12));
		set.add(new Users(12));
		set.add(new Users(12));
		set.add(new Users(13));
		set.add(new Users(14));
			
		System.out.println(set);
	}
	
	
	
	//HashSet  
	public void testname() {  
		HashSet set= new HashSet();
		set.add(123);
		set.add(23);
		set.add(13);
		set.add(3);
		set.add(3);
		set.add("3");
		set.add("3");
		set.add("3");
      for (Object object : set) {
		System.out.println(object);
	}
	 
      System.out.println("-----------");
      Iterator iter= set.iterator();
      while(iter.hasNext()) {
    	  System.out.println(iter.next());
    	  
      }
	}
	
}
