package com.se.day01.pojo;

public class Users {

	 private  Integer  age;

	 
	 
	 
	 
	 
	 
	 
	@Override
	public int hashCode() {
		return age;
	}

	@Override
	public boolean equals(Object obj) {
		   if(this ==obj)
			   return true;
		   //
		   if(!(obj instanceof Users))
			 throw new ClassCastException("类型不一致");
		   Users  us=  (Users)obj;
		return this.age==us.age;
	}

	public Users() {
		super();
	}
	 
	public Users(Integer age) {
		super();
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [age=" + age + "]";
	}
	 
	 
	 
	 
	
}
