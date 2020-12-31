package com.bj.pojo;

public class Users {

	private  Integer  id;
	
	private  String  name;
	
	private  String  age;

	private  Integer  lastAge;
	
	
	public Integer getLastAge() {
		return lastAge;
	}

	public void setLastAge(Integer lastAge) {
		this.lastAge = lastAge;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", age=" + age + ", lastAge=" + lastAge + "]";
	}
	
	
	
	
}
