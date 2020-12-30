package com.java.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

///取出重复的使用ArrayList
public class Test4 {

	
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list);
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("---------------");
		ArrayList newlist=new ArrayList();
		Iterator  i=list.iterator();//
		while(i.hasNext()) {//判断是否有元素
			 String s=(String)i.next();//获取到旧集合中的元素
			 if(!newlist.contains(s)){//如不包含该元素
				 newlist.add(s);//进行添加到新的集合中
			 }
		}
		System.out.println(newlist);
	}
}
