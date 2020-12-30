package com.java.test;

import java.util.Comparator;

public class Student implements Comparable<Student> {

	private String name;
	private Integer age;
	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	



	public Student() {
		super();
	}








	@Override
	public int compareTo(Student o) {
		int i=this.age-o.age;
		return i==0?this.name.compareTo(o.name):i;
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
		return "Student [name=" + name + ", age=" + age + "]";
	}






	
	

}
