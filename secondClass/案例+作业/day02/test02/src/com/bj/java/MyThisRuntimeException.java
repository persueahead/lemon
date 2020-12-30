package com.bj.java;

//自定义异常 常用
//回想，之前子类继承了父类 ，那么子类同样的。。。。。?
public class MyThisRuntimeException extends RuntimeException{

	public MyThisRuntimeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyThisRuntimeException(String message, Throwable cause) {
	super(message, cause);
		// TODO Auto-generated constructor stub
	}

	
	
	public MyThisRuntimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
