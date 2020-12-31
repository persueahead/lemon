package com.se.day01.lists;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * ArrayList 底层就一个数组
 * 
 * @author Administrator
 *
 */
public class TestArrayList {

	public static void main(String[] args) {
		  new TestArrayList().testname01();
	}
	
	
	public void testname01(){
		  ArrayList<Integer> array=    new ArrayList();
		  array.add(123);//0
		  array.add(3);//1
		  array.add(31);//2
		  array.add(32);//3
		  array.add(333);
		  //删除元素
		  array.remove(3);//传入的是下标
		 // array.clear();//清空集合
		//  如果此列表中包含指定的元素，则返回 true。
		  System.out.println("contains：-----"+array.contains(333));
		  System.out.println("array：-----"+array);
		  Object[] obj= array.toArray();//转换为数组
		
		
		
		
	}
	
	
	//ArrayList集合创建于遍历
	  public void testname(){
		  ArrayList array=    new ArrayList();
		  array.add(123);
		  array.add(3);
		  array.add(23);
		  array.add(13);
		  System.out.println(array);
		  //获取某个数据
		  //方式一：
		    //使用for
		  for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		  	}
		  System.out.println("-------------");
		  //方式二
		  for (Object object : array) {
			System.out.println("object:"+object);
		  }
		  
		  //方式三
		  Iterator  itr=  array.listIterator();
		  while(itr.hasNext()) {
			  System.out.println("Iterator："+itr.next());
		  }
		  //方式四
		  Iterator  itrs=   array.iterator();
		  while(itrs.hasNext()) {
			  System.out.println(itrs.next());
		  }
	}
	
	
	
	

}
