package com.example.ln.po;

/**
 * 学生信息
 * @author Administrator
 *
 */
public class Student {

	//学号
	private Integer id;
	
	//姓名
	private String name;
	
	//性别
	private String sex;
	
	//年龄
	private Integer age;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
