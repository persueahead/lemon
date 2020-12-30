package com.bj;

public class Student {

	
	private  String  name;
	
	private int  age;
	
	public  String  gender;
	
	public int    monery;

	public Student(String name, int age) {
		System.out.println("public Student(String name, int age) {"+name+":"+age);
		this.name = name;
		this.age = age;
	}
	
	public Student(String name, int age, String gender, int monery) {
		System.out.println("public Student(String name, int age, String gender, int monery) {"+name+":"+age);
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.monery = monery;
	}

	public Student() {
		System.out.println("	public Student() {");
	}
	
	
	
	
	public void testVoid() {
		System.out.println("public void testVoid() {");
	}
	
	public void testVoid(String  name) {
		System.out.println("	public void testVoid(String  name) {");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMonery() {
		return monery;
	}

	public void setMonery(int monery) {
		this.monery = monery;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + ", monery=" + monery + "]";
	}
	
	
	
	
	
	
}
