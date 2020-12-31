package com.se.day01.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
/**
 *Iterator
 * 
 * @author Administrator
 *
 */
public class TestIterator {

	public static void main(String[] args) {
		  new TestIterator().testname01();
	}
	//ArrayList集合创建于遍历
	  public void testname01(){
		  ArrayList array=    new ArrayList();
		  array.add(123);
		  array.add(3);
		  array.add(23);
		  array.add(13);
		  //方式三
		  ListIterator  itr=  array.listIterator();
		  while(itr.hasNext()) {
			  System.out.println("Iteratorz："+itr.next());
		  }
		  System.out.println("--------------");
		  itr.add(1211111);
		  itr.add(10211111);
		  itr.add(12011111);
		  while(itr.hasPrevious()) {
			  System.out.println("Iterator："+itr.previous());
		  } 
	  
		 System.out.println("array"+array); 
		  
	  }
	//ArrayList集合创建于遍历
	  public void testname(){
		  ArrayList array=    new ArrayList();
		  array.add(123);
		  array.add(3);
		  array.add(23);
		  array.add(13);
		  
		  
		  
		  
		  //方式三
		  Iterator  itr=  array.listIterator();
		  itr.next();
		  itr.remove();
		  while(itr.hasNext()) {
			  System.out.println("Iterator："+itr.next());
		  }
		  System.out.println("--------------");
		  //方式四
		/*
		 * Iterator itrs= array.iterator(); while(itrs.hasNext()) {
		 * System.out.println(itrs.next()); }
		 */
	}
	
	
	
	

}
