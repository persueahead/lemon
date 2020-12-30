package com.exercise;

public class Resume {
  public static void main(String[] args) {
	  Person per=new Person();
	  per.name="郑天威";
	  per.age =22;
	  per.gender="男";
	  per.qq=964100803;
	  per.wx="月舞";
	  per.mobilePhone=15897706156l;
	  per.emile="15897706156@163.com";
	  per.mainClass="信号与系统，通信原理";
	  per.projectedExperience="电子系统综合设计";
	  per.studyExperience="京山县第一高级中学，湖北工程学院";
	  per.print(); 
	 }
  }
class Person{
	String name;
	int age;
	String gender;
	int qq;
	long mobilePhone;
	String wx;
	String emile;
	String studyExperience;
	String mainClass;
	String projectedExperience;
	public void print() {
		System.out.println("姓名："+name);
		System.out.println("性别："+gender);
		System.out.println("年龄："+age);
		System.out.println("电话："+mobilePhone);
		System.out.println("QQ："+qq);
		System.out.println("微信："+wx);
		System.out.println("邮箱："+emile);
		System.out.println("学习经历："+studyExperience);
		System.out.println("主修课程："+mainClass);
		System.out.println("项目经验："+projectedExperience);
	}
	
}