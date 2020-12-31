package com.bj.pojo;

public class Users {

	private  String  name;
	private  int  age;
	public  String  lastName;
	public  int  sex;
	
	
	
	public Users(String name, int age, String lastName, int sex) {
		super();
		this.name = name;
		this.age = age;
		this.lastName = lastName;
		this.sex = sex;
		System.out.println("	public Users(String name, int age, String lastName, int sex) {");
		
	}
	
	@Override
	public String toString() {
		return "Users [name=" + name + ", age=" + age + ", lastName=" + lastName + ", sex=" + sex + "]";
	}

	public Users(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("	public Users(String name, int age) {");
	}
	public Users( int age,String name) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("	public Users( int age,String name) {");
		System.out.println("	public Users( int age,String name) {"+age+"==="+name);
	}
	public Users() {
		super();
		System.out.println("	public Users() {");
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		System.out.println("public String getName() {");
		
		return name;
	}
	public void setName01(String name,int i) {
		System.out.println("	public void setName01(String name,int i) "+name+"==="+i);
		
		this.name = name;
	}
	
	public void setName(String name) {
		System.out.println("	public void setName(String name) {");
		
		this.name = name;
	}
	public int getAge() {
		System.out.println("	public int getAge() {");
		
		return age;
	}
	public void setAge(int age) {
		System.out.println("	public void setAge(int age)");
		this.age = age;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
}
