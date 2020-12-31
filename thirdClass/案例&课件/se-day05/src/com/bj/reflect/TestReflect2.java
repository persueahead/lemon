package com.bj.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.bj.pojo.Users;

public class TestReflect2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			//之前是这样玩的
		
		new TestReflect2().testname04();
	}
/**
 * 获取变量
 * @throws Exception
 */
	public void testname04() throws Exception {
		Users u=  new Users("隔壁老陈",88,"心意小姐姐",23);
		System.out.println("之前传入的数据信息::::::::"+u);
		Class  cl=	Users.class;
		
		System.out.println("----打印出所有公共的属性名-------");
		Field[] fi=cl.getFields();
		for (Field field : fi) {
			System.out.println(field.getName());
		}
		System.out.println("-----打印出所有属性名(包含私有的)----------------");
		Field[] f2=cl.getDeclaredFields();
		for (Field field : f2) {
			System.out.println(field.getName());
		}
		System.out.println("======通过反射重新进行(公共的)属性的值================");
		Field  F3=cl.getField("lastName");
		   System.out.println("之前==获取对应的值：："+F3.get(u));
		   //进行设置
		   F3.set(u, "小仙女");
		   System.out.println("设置之后的==获取对应的值：："+F3.get(u));
		   System.out.println(u);
			System.out.println("======通过反射重新进行(私有的)属性的值================");
			Field  f4=	cl.getDeclaredField("name");
		   //开启Private设置  true标示可以进行对私有化得操作(默认为false)
			f4.setAccessible(true);
			  System.out.println("之前==获取对应的值：："+f4.get(u));
			  f4.set(u,"隔壁老王");
			  System.out.println("设置之后的==获取对应的值：："+f4.get(u));  
			  System.out.println(u);
	}
	
	
	/**
	 * 获取所有的方法
	 *  并进行执行某个方法(有参数的)
	 * @throws Exception
	 */
	public void testname03() throws Exception {
		Class  cl=	Users.class;
		//获取指定的某个的方法
		/**
		 * 参数一:  调用的某个方法的名称
		 * 参数二:该方法中的参数的类型注意(类型和顺序一致)
		 */
		Method  me=cl.getMethod("setName01",String.class,int.class);
		
		Constructor  co=	cl.getConstructor();
		Users  users=(Users)co.newInstance();
		me.invoke(users,"隔壁小姐姐",23);
		
	}
	

	/**
	 * 获取所有的方法
	 *  并进行执行某个方法
	 * @throws Exception
	 */
	public void testname02() throws Exception {
		Class  cl=	Users.class;
		//获取所有的方法
		 Method[]  me=	cl.getMethods();
         for (Method method : me) {
        	 System.out.println("方法:+++"+method.getName());
        	 //进行调用某一个方法
			if(method.getName().contains("getName")) {
				Constructor  co=	cl.getConstructor();
				Users  users=(Users)co.newInstance();
				method.invoke(users);
			}
		}		 
	}
	
	
	
	
	
	/**
	 * 调用无参数的构造函数
	 * @throws Exception
	 */
	public void testname01() throws Exception {
		Class  cl=	Users.class;
		Constructor  constructor=
				cl.getConstructor();
		Users  users=(Users)constructor.newInstance();
		System.out.println(users);
		
	}
	
	
	/**
	 * 通过反射进行调用带参数的构造函数
	 * @throws Exception
	 */
	public void testname() throws Exception {
	Class  cl=	Users.class;
	/**
	 * 调用带两个参数的构造方法
	 *    注意getConstructor(....)传入参数类型的时候，
	 *       一定要和你调用的构造方法的参数的类型包括顺序一致
	 *       如getConstructor(Integer.class,String.class)
	 *    调用无参的构造函数,那么就无写参数类型，就可以进行调用了
	 *        
	 */
	Constructor  constructor=
			cl.getConstructor(int.class,String.class);
	//需要进行强制转换
	/**
	 * 转换传入参数的时候，要和你调用构造函数的参数类型(顺序)
	 *     一致
	 */
	Users  users=(Users)constructor.newInstance(123123,"隔壁老陈");
	System.out.println("users:"+users);
	}
}
