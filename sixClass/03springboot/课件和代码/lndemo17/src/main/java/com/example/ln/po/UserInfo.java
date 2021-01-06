package com.example.ln.po;

/**
 * 用户管理的实体类
 * @author Administrator
 *
 */
public class UserInfo {

	public int id;
	
	private String name;
	
	private String sex;
	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
	
	
	
	
}
