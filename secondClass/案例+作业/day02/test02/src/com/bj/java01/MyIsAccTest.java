package com.bj.java01;

import static com.bj.java.MyIsAcc.*;
import com.bj.java.MyThisRuntimeException;

//自定义异常
public class MyIsAccTest {

	public  void getSerivce(String name)throws MyThisRuntimeException {
		getIsNotNull("用户名称不能为空", name);
	}
	
	
	public  void getUsersSerivce(String  pwd) {
		getIsNotNull("密码不能为空", pwd);	
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

