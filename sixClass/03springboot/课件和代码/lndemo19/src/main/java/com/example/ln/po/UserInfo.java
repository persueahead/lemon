package com.example.ln.po;

import java.io.Serializable;

/**
 * 用户管理的实体类
 * @author Administrator
 *
 */
public class UserInfo implements Serializable{

	private Integer id;

	private String name;

	private String sex;

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

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}

}
