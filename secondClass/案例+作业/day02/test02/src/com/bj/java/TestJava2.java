package com.bj.java;

//自定义异常
public class TestJava2 {

	
	//常用的一种 
	/**
	 *自定义异常的好处:
	 *   能用使用中文，展示给用户,让用户更加明白,异常的信息
	 *   也可以进行自定义相关的异常提示信息
	 *    
	 */
	public  void  getTest(int  i){
		if(i==0) {
			//进行生命自定义异常
			//在这里传入的参数就是给用展示/提示用户的信息
			throw new MyThisRuntimeException("除数不能为0");
		}else {
			System.out.println(i+"可以当成除数");
			System.out.println(i/i);
		}
	}
	
	public static void main(String[] args) {
		try {
			
			new TestJava2().getTest(0);
		} catch (Exception e) {
		String i=e.getMessage();
		System.out.println(i);
		}
	}

	
	/*
	 * public static void main(String[] args) { int i=1/0; System.err.println(); }
	 */
	
	
	
	
}

