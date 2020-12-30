package com.java.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class Test02 {

	/**
	 *   ������ֲ�����(����)�������  �쳣
	 *    ����      ������ִ�����ں�ɫ 
	 * 
	 *    Error
	 *       java���������
	 *         jvmϵͳ�ڲ�����,��Դ������....
	 *         һ�㲻�����
	 *         
	 *       
	 *    
	 *    Exception
	 *      ���(����)�쳣
	 *          �������ص��µ����� �����Խ��д����ԵĴ���
	 *         ��  
	 *           �±�Խ��
	 *           ��ָ��
	 *           ......
	 *            
	 *       ����ʱ�쳣    	
	 *          ������Ϊ0
	 * 
	 * 
	 *    һ������쳣
	 *    
	 *    
	 *    �쳣�Ĵ���
	 *    		  �ܳ�
	 *       			 throws  XXXXX
	 *    		����
			 *    			try...	
						 *      try {
							} catch (ParseException e) {
								e.printStackTrace();
							}
	 *      ********���õ�����һ�ֵĴ���ʽ?***
	 *      	�ܳ�(����)
	 *      Ϊʲô?
	 *      			����쳣û���ڵ����߷����н��д���,�Ὣ����쳣�׸���һ��
	 *       A��B  B��C  
	 *          C�и��쳣�ܳ�  ��ô A��B  B��C    ��A��B�ͻ�֪��C�и��쳣Ҫ���д���
	 *          ��ʹ��
	 *         		  try {} catch 
	 *       		 A��B  B��C C�и�
	 *               	  B������D  
	 *       		C�е��쳣������,û���쳣��
	 *             ��ôA ��B  ��������⣬ û�з������о�ȷ���Ǹ������ϵ��쳣�����
	 *        
	 *      
	 *      *****
	 *      
	 *         �쳣�Ķ�������
	 *      		 ���������
	 *        �����������У�����������Է���������
	 *          ��������
	 *              ��ȥ�ҵ���Ӧ�ô����쳣�Ĵ���
				�Զ�
	 *                ��ʾ���� �Զ����ܳ����� ����
	 *          �ֶ�     
	 *              �ʹ�������һ���ķ�ʽ
	 *    �ܳ�����     ����           ?    
	 *          �ܳ�      throws ParseException 
	 * 				���쳣�Ķ��󽫰�����쳣ֱ�ӵ��׸����øö����ʹ���������д�������쳣
	 * 				����쳣û���ڵ����߷����н��д���,�Ὣ����쳣�׸���һ��
	 * 			����  
	 * 				 try {} catch (ParseException e) {}
	 * 				���һ���쳣��������ô���д���try {} catch ()����
	 * 				����쳣�������ok ������н����쳣����һ��
	 * 
	 * 
	 * ע��:
	 *  ���Exception�����˵��쳣����ô��������Ϊ����
	 *    Error  ͳ�ڲ�����,��Դ������   �������ʱȲ�Ʊ��Ҫ�� 
	 * 
	 */
	
	
	
	
	/**
	 * �����쳣���﷨
	 * һ��
	 * 	
	 *    try  catch
	 *    try {
				sim.parse("");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 * ����
	 * 		try  finally 
	 *    û�н���Ӧ���쳣���д���  ,����Ҫ���е����Ĵ����쳣
	 *    ע��
	 *      finally ,�����쳣��û�н��д��������ִ��
	 *      
	 * ����  try catch .....  finally
	 * ע��:
	 *   �㼶��ϵ
	 *     catch��catch�Ĺ�ϵ  ��һ��catch���catch�Ĺ�ϵ  ���쳣�����࿪ʼ
	 *      �����catch ��ǰ���catch�ĸ����쳣
	 *     
	 *      
	 *      
	 *      
	 *  �Ƴ�
	 *    ����һ����ֱ�ӵĵ���ʱ�׳����쳣
	 *        �����õķ����ܳ����쳣�����ǵ��÷����׳����쳣��ͬ���������
	 *        ���ܸ���
	 *
	 * 
	 * 
	 * ����try  catch
	 *   try{....}  ��ʶ�����쳣�Ĵ����.���ܻ�����쳣�Ĵ���Ҫ����{....}����
	 *   catch (Exception e) {}
	 *    catch{......}��ĳ���쳣���д���Ĵ���
	 *    (Exception e)  ָ�������쳣�Ķ��� ������ͨ��e������Ӧ�ķ���
	 *      �� ����
	 *        e.toString();
	 *        e.getMessage(); ��ȡ�쳣����Ϣ
	 *        e.printStackTrace();���쳣�������
	 *     ���ֶ��catch��JDK1.7�Ժ�汾�ſ�
	 *      ���catch��ָ���봦��ͬ���쳣��Ϣ���������õ�,ע��㼶��ϵ   
	 *     ������Щ�����catch���쳣��
	 *     Ϊ��,�����������ڴ����쳣�ľ�ȷ  �����ö��߸�����ȷ������쳣
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
				//����
				Date  dat=	sim.parse(st);
	}
	
	
	@Test
	public void test05() throws Exception   {
		SimpleDateFormat  sim
		=new SimpleDateFormat();
		String st=	sim.format(new Date());
			try {
				//����
				Date  dat=	sim.parse(st);
				System.out.println("---------��������--------");
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
				//����
					try {
							Date  dat=	sim.parse(st);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int I=3/0;
				System.out.println(I);
				System.out.println("---------��������--------");
			}finally {
				System.out.println("-----------------");
				
				
			} 
			
		
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	public void test03()   {
		ClassCastException  exceptionnew =new ClassCastException();
		test02();
	}
	
	//��ǰ��֪���쳣
	//  throws
	// try 
	//˭�ڴ���?
	//jvm  �ڴ���
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
