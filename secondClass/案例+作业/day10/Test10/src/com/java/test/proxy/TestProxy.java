package com.java.test.proxy;

import java.lang.reflect.Proxy;

import com.java.test.proxy.impl.IUsersImpl;

public class TestProxy {

	public static void main(String[] args) {
		IUsersImpl  impl=	new IUsersImpl();
		impl.add();
		System.out.println("---------------------");
		MyUsersHandler  mu=	 new MyUsersHandler(impl);
		
		IUsers  iu=(IUsers)	Proxy.newProxyInstance(impl.getClass().getClassLoader(),
				impl.getClass().getInterfaces(),mu);
		iu.del();
		System.out.println("=================");
		System.out.println(impl.getClass().getName());
		System.out.println(impl.getClass().getName());
	}
}
