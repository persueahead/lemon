package com.java.test;

import java.io.Serializable;

//如果某个对象需要使用对象流来进行处理
//那么该就对象就需要进行实现Serializable
//并且添加serialVersionUID值
public class Users implements Serializable {
	//private static final long serialVersionUID = -4821871089038224682L;

/**
	 * 自动的有可能会导致不兼容的问题
	 * ,不要自动，进行手动添加serialVersionUID
	 * 
	 * 什么是对象序列化机制
	 *    	内存中的java对象转换成与平台无关的二进制流，从而允许吧这样的而进制流持久的保存在磁盘中
	 *      也也可进行通过网络的方式，将这种二进制流传输到某个网络上的节点
	 *      如其他程序需要获取这种二进制流的就需要进行恢复成原来的java对象(反序列化)
	 *      
	 *     好处: 可以将任何实现了的 Serializable接口的对象进行转化为字节数据.在保存和传输中可以被还原
	 *     
	 *     如某个对象支持序列化的机制就必须进行实现Serializable接口
	 *     只要实现了Serializable接口的类,都有一个静态变量(版本表示符)
	 *       用来表明类的不同的版本(兼容性)
	 */
	private static final long serialVersionUID = 1L;
	
	

private String name;

private int age;

private  Person  person;



public Person getPerson() {
	return person;
}

public void setPerson(Person person) {
	this.person = person;
}

public Users(String name, int age) {
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
