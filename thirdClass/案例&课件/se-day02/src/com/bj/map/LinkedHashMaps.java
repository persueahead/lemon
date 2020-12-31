package com.bj.map;

import java.util.LinkedHashMap;

public class LinkedHashMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new LinkedHashMaps().testname();
	}

	
	public void testname(){
		LinkedHashMap<String,Integer> ha=    new LinkedHashMap();
		ha.put("D", 161);
		ha.put("A", 151);
		ha.put("C", 141);
		ha.put("F", 131);
		ha.put("D", 121);
		System.out.println(ha);
	}
}
