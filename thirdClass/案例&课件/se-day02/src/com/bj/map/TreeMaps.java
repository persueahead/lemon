package com.bj.map;

import java.util.Comparator;
import java.util.TreeMap;

import com.bj.pojo.Users;

public class TreeMaps {

	
	public static void main(String[] args) {
		 new TreeMaps().testname();
	}

  public void testname(){
	  TreeMap<Users ,String>  map=   
			  new TreeMap(new Comparator<Users>() {
				@Override
				public int compare(Users o1, Users o2) {
					    int i=o1.getName().compareTo(o2.getName());
					return i==0?o1.getAge()-o2.getAge():i;
				}
	});
	  
	  map.put(new Users("A",11) , "1111");
	  map.put(new Users("A",121) , "2222");
	  map.put(new Users("b",113) , "3333");
	  map.put(new Users("c",141) , "4444");
	  map.put(new Users("d",115) , "555");
	  System.out.println(map);
	  
	  
	  
	
}

}

