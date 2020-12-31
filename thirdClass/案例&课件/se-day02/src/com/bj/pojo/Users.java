package com.bj.pojo;

public class Users implements Comparable<Users> {
	
	  private  String name;
	  private Integer  age;
	  
		@Override
		public int compareTo(Users o) {
        int i=this.age-o.age;
			
			return i==0?this.name.compareTo(o.name):i;
		}
	  
	  
	@Override
		public String toString() {
			return "Users [name=" + name + ", age=" + age + "]";
		}


	public Users(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Users() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	  
	  
	  

}
