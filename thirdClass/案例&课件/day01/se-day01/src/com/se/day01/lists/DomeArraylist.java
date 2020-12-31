package com.se.day01.lists;

import java.util.ArrayList;
import java.util.Iterator;

public class DomeArraylist {

	
	public static void main(String[] args) {
		  new DomeArraylist().testName();
	}

	//使用Arrlist去除重复的字符串
	public void testName(){
		 ArrayList<String>  arry=     new ArrayList<String>();
		 arry.add("a");
		 arry.add("a");
		 arry.add("a");
		 arry.add("a");
		 arry.add("b");
		 arry.add("b");
		 arry.add("ab");
		 arry.add("ab");
		 arry.add("ab");
		 arry.add("ab");
		 arry.add("c");
		 arry.add("c");
		 ArrayList<String>  arry1= testName01(arry);
		  System.err.println(arry1);
		
	}
	public ArrayList testName01(ArrayList array){
		ArrayList ar=   new ArrayList();
		Iterator  itr=	array.iterator();
		while(itr.hasNext()) {
			String str=(String) itr.next();
		  if(!ar.contains(str)) {
			  ar.add(str);
		  }
		}
		return ar;
	}
	}


