package com.java.test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;


///HashSet
public class Users  implements Comparable<Users>{

	private  String name;
	private  Integer  age;
	@Override
	public int compareTo(Users o) {
			int le=this.name.length()-o.name.length();
		  int i= le == 0?this.name.compareTo(o.name):le;
		return i==0 ?this.age-o.age:i;
	}
	
	
	public Users(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", age=" + age + "]";
	}

	
	
	
	
}
