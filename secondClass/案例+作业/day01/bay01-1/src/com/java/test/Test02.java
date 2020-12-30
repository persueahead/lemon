package com.java.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class Test02 {

	/**
	 *   程序出现不正常(报错)的情况下  异常
	 *    错误      程序不能执行现在红色 
	 * 
	 *    Error
	 *       java虚拟机问题
	 *         jvm系统内部错误,资源的消耗....
	 *         一般不会出现
	 *         
	 *       
	 *    
	 *    Exception
	 *      编程(编译)异常
	 *          外在因素导致的问题 ，可以进行代码性的处理
	 *         如  
	 *           下标越界
	 *           空指针
	 *           ......
	 *            
	 *       运行时异常    	
	 *          除数不为0
	 * 
	 * 
	 *    一种类的异常
	 *    
	 *    
	 *    异常的处理
	 *    		  跑出
	 *       			 throws  XXXXX
	 *    		捕获
			 *    			try...	
						 *      try {
							} catch (ParseException e) {
								e.printStackTrace();
							}
	 *      ********常用的是哪一种的处理方式?***
	 *      	跑出(常用)
	 *      为什么?
	 *      			如果异常没有在调用者方法中进行处理,会将这个异常抛给上一层
	 *       A调B  B调C  
	 *          C有个异常跑出  那么 A调B  B调C    哪A和B就会知道C有个异常要进行处理
	 *          如使用
	 *         		  try {} catch 
	 *       		 A调B  B调C C有个
	 *               	  B调用了D  
	 *       		C中的异常处理了,没有异常了
	 *             那么A 和B  如出现问题， 没有方法进行精确到那个方法上的异常能理解
	 *        
	 *      
	 *      *****
	 *      
	 *         异常的对象生成
	 *      		 虚拟机生成
	 *        程序在运行中，虚拟机检测测试发生的问题
	 *          如有问题
	 *              就去找到对应得处理异常的代码
				自动
	 *                提示我们 自动的跑出或者 捕获
	 *          手动     
	 *              和创建对象一样的方式
	 *    跑出捕获     区别           ?    
	 *          跑出      throws ParseException 
	 * 				该异常的对象将把这个异常直接的抛给调用该对象的使用者来进行处理这个异常
	 * 				如果异常没有在调用者方法中进行处理,会将这个异常抛给上一层
	 * 			捕获  
	 * 				 try {} catch (ParseException e) {}
	 * 				如果一个异常方法中那么进行处理try {} catch ()。。
	 * 				这个异常如果处理ok 不会进行将该异常给上一层
	 * 
	 * 
	 * 注意:
	 *  如果Exception处理不了得异常，那么就是无能为力了
	 *    Error  统内部错误,资源的消耗   遇到几率比彩票都要难 
	 * 
	 */
	
	
	
	
	/**
	 * 捕获异常的语法
	 * 一种
	 * 	
	 *    try  catch
	 *    try {
				sim.parse("");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 * 二种
	 * 		try  finally 
	 *    没有将对应得异常进行处理  ,如有要进行单独的处理异常
	 *    注意
	 *      finally ,无论异常有没有进行处理都会进行执行
	 *      
	 * 三种  try catch .....  finally
	 * 注意:
	 *   层级关系
	 *     catch与catch的关系  第一个catch与二catch的关系  从异常的子类开始
	 *      后面的catch 是前面的catch的父类异常
	 *     
	 *      
	 *      
	 *      
	 *  推出
	 *    方法一方法直接的调用时抛出的异常
	 *        被调用的方法跑出的异常必须是调用方法抛出的异常的同类或是子类
	 *        不能父类
	 *
	 * 
	 * 
	 * 解释try  catch
	 *   try{....}  标识捕获异常的代码块.可能会出现异常的代码要放在{....}里面
	 *   catch (Exception e) {}
	 *    catch{......}对某个异常进行处理的代码
	 *    (Exception e)  指定处理异常的对象 ，可以通过e调用相应的方法
	 *      如 常用
	 *        e.toString();
	 *        e.getMessage(); 获取异常的信息
	 *        e.printStackTrace();将异常进行输出
	 *     出现多个catch是JDK1.7以后版本才可
	 *      多个catch是指定与处理不同的异常信息来进行设置的,注意层级关系   
	 *     代码中些多个的catch的异常是
	 *     为了,让整个代码在处理异常的精确  还有让读者更加明确处理的异常
	 *     
	 * 
	 */
	
	@Test
	public void testName() throws Exception {
		test06();
	}
	
	@Test
	public void test06() throws ParseException   {
		SimpleDateFormat  sim
		=new SimpleDateFormat();
		String st=	sim.format(new Date());
				//解析
				Date  dat=	sim.parse(st);
	}
	
	
	@Test
	public void test05() throws Exception   {
		SimpleDateFormat  sim
		=new SimpleDateFormat();
		String st=	sim.format(new Date());
			try {
				//解析
				Date  dat=	sim.parse(st);
				System.out.println("---------三生三世--------");
			}catch (  ParseException e) {
				e.getMessage();
				e.printStackTrace();
				
				// TODO: handle exception
			}catch (Exception xxxxx) {
				
				// TODO: handle exception
			}finally {
				System.out.println("-----------------");
			} 
			
		
	}
	
	@Test
	public void test04()  {
		SimpleDateFormat  sim
		=new SimpleDateFormat();
		String st=	sim.format(new Date());
		System.out.println(st);
			try {
				//解析
					try {
							Date  dat=	sim.parse(st);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int I=3/0;
				System.out.println(I);
				System.out.println("---------三生三世--------");
			}finally {
				System.out.println("-----------------");
				
				
			} 
			
		
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	public void test03()   {
		ClassCastException  exceptionnew =new ClassCastException();
		test02();
	}
	
	//提前告知的异常
	//  throws
	// try 
	//谁在处理?
	//jvm  在处理
	@Test
	public void test02()   {
		SimpleDateFormat  sim
		=new SimpleDateFormat();
	
			try {
				sim.parse("");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	public void testname() throws Exception {
		
	}
	@Test
	public void test01()  {
		
		 int  [] arr= {1,2,4,6,7};
		 System.out.println(arr[13]);
		
	}
	
}
