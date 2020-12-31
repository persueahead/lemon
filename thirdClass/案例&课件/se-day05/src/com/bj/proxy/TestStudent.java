package com.bj.proxy;

import java.lang.reflect.Proxy;

import com.bj.proxy.student.Student;
import com.bj.proxy.student.StudentImpl;

public class TestStudent {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new TestStudent().testname01();
	}

	/**
	 * 使用了代理
	 * @throws Exception
	 */
	public void testname01() throws Exception {
		Student  IStudent= new StudentImpl();
		MyHandler  myHandler=  new MyHandler(IStudent);
		Student  s=(Student)Proxy.newProxyInstance(IStudent.getClass().getClassLoader(),
				IStudent.getClass().getInterfaces(),myHandler);
		s.login();
		s.submit();
	}
	
	
	/**
	 * 之前调用的方法
	 * @throws Exception
	 */
	public void testname() throws Exception {
		//之前使用这样的方式
				Student  IStudent= new StudentImpl();
				//调用验证信息的方法
				IStudent.login();
				//代用日志的方法或者事务的方法
	}
}
