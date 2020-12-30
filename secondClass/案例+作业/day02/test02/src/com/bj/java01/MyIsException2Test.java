package com.bj.java01;

public class MyIsException2Test {

	public  void getTest(int i) throws MyIsException {
	  if(i==0){
		  throw new MyIsException("不能为0");
	  }else {
		  System.out.println("可以使用该数字");
	  }	
		
		
	}
	
	
	public static void main(String[] args) {
		  try {
			new MyIsException2Test().getTest(0);
		} catch (MyIsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
