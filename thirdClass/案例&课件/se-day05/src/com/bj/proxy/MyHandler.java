package com.bj.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
	private  Object  obj;
	public MyHandler(Object obj) {
		super();
		this.obj = obj;
	}
	public MyHandler() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("调用验证账号和密码的方法逻辑");
		method.invoke(obj, args);
		System.out.println("调用提交登陆产生日志的方法逻辑");
		return null;
	}

}
