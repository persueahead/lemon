package com.java.test;

//线程
//注意:子类需要进行重写run方法
public class Student2  extends  Thread{

	@Override
	public void run() {
		//写上你对应的逻辑 如循环20次
		System.out.println("我执行了Student2 ");
	}
	
	
	
	
}
