package com.se.day01.pojo;

import java.util.Comparator;

public class Person implements Comparable<Person> {
   
	private  String name;
	private  Integer  age;
	@Override
	public int compareTo(Person o) {
		   //主要的条件名字的长度
		int naemLength=this.name.length()-o.name.length();
		//次要条件
		int num=naemLength==0?this.name.compareTo(o.name):naemLength;
		//通过年龄对比
		return num==0?this.age-o.age:num;
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	
	}
	
	
	
	
	
}
