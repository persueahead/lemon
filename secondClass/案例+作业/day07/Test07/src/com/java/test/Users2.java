package com.java.test;

import java.io.Serializable;

//如果某个对象需要使用对象流来进行处理
//那么该就对象就需要进行实现Serializable
//并且添加serialVersionUID值
public class Users2 implements Serializable {
	//private static final long serialVersionUID = -4821871089038224682L;

/**
	 * 自动的有可能会导致不兼容的问题
	 * ,不要自动，进行手动添加serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	

private String name;

private int age;





public Users2(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}

public Users2() {
	super();
	// TODO Auto-generated constructor stub
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

@Override
public String toString() {
	return "Users [name=" + name + ", age=" + age + "]";
}



	
}
