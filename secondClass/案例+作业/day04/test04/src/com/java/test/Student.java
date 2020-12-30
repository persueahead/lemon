package com.java.test;

public class Student {

	
	private  String name;

	
	
	public Student(String name) {
		super();
		this.name = name;
	}

	//重新方法
	
	
	
	public String getName() {
		return name;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
			if(this==obj)
					return true;
			if(!(obj instanceof Student )){//进行判断是不是当前类的一个实挒
				 throw new  ClassCastException("类型错误");
			}	
			Student s=(Student)obj;
		return this.name==s.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
	
	
	
}
