package com.bj.java;

//自定义异常
public class MyIsAccTest {

	public  void getSerivce(String name)throws MyThisRuntimeException {
		MyIsAcc.getIsNotNull("用户名称不能为空", name);
	}
	
	
	public  void getUsersSerivce(String  pwd) {
		MyIsAcc.getIsNotNull("密码不能为空", pwd);	
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			new MyIsAccTest().getSerivce(null);
		} catch (Exception e) {
				System.out.println(e.getMessage());
			e.getSuppressed();

		}
	}
	
	
}

