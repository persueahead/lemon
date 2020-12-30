package com.bj.java;

public class TestJava01 {

	
	
	
	
	
	
	
	
	

	//案例:  面试容易问
	//请问  finally里面return会执行吗?
  public  static  int getTest01() {
	    int i=2;
	    try {
			i=4;
			System.out.println(2/0);
			System.out.println(i);
			return i;
		} catch (Exception e) {
			i=5;
			System.out.println(i);
			return i;
		}finally {
			i=6;
			System.out.println(i);
			return i;
		}
  }
	
	
	public static void main(String[] args) {
   int  i=		getTest01();
System.out.println("结果"+i);
	}

}

