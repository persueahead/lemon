package com.java.test.pojo;

public class Users {

	 private String name;
	 public String lastName;
	 private  int age;
	 public int monery;
	 
	 
		public Users() {
		}
	 
		public Users(String name) {
			super();
			this.name = name;
		}

	public Users(String name, String lastName, int age, int monery) {
			super();
			this.name = name;
			this.lastName = lastName;
			this.age = age;
			this.monery = monery;
		}

	

	@Override
	public String toString() {
		return "Users [name=" + name + ", lastName=" + lastName + ", age=" + age + ", monery=" + monery + "]";
	}

	public void testname() {
		System.out.println("	public void testname() {");
	}
	 
	public void testname(String name,int age) {
		System.out.println("	public void testname(String name) {"+name+":"+age);
	}
	
	 
	public void testname(String age) {
		System.out.println("	public void testname(int age) {");
	}
	 
	 
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMonery() {
		return monery;
	}
	public void setMonery(int monery) {
		this.monery = monery;
	}
	
	 
	 
	 
	 
	
}
