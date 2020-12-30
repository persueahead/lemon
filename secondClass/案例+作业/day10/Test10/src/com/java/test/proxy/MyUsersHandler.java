package com.java.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyUsersHandler implements InvocationHandler {
	private Object object;
	public MyUsersHandler(Object object) {
		this.object = object;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("开启事务...............................................");
			method.invoke(object, args);//就是需要进行完成的代理的具体的方法
			System.out.println("......关闭事务.........................................");
		return null;
	}
	
	
}
