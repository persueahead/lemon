package com.bj.map;

import java.util.Properties;

public class Propertiess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          new Propertiess().testname();
	}

	//获取数据源的使用后进行用到
	public void testname(){
		Properties pr=  new Properties();
	//	pr.put(123, 1212);//一般的情况不会这进行put数据
		pr.setProperty("usersname","xxxxoooo");
		pr.setProperty("password","11211");
		System.out.println(pr.getProperty("password"));
		System.out.println(pr);
	}
	
}
