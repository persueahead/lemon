package com.se.day01.lists;

import java.util.Comparator;
import java.util.TreeSet;

import com.se.day01.pojo.Person;

public class TestTreeSet {

public static void main(String[] args) {
	 new TestTreeSet().testname03();
}

public void testname03() {
	 TreeSet<Person>  tree= new  TreeSet();
	 tree.add(new Person("a",1)); 
	 tree.add(new Person("aa",12)); 
	 tree.add(new Person("bb",6)); 
	 tree.add(new Person("aaaa",13)); 
	 tree.add(new Person("aaaa",14)); 
	 tree.add(new Person("ff",10)); 
	
	 System.out.println(tree);
}

public void testname02() {
	 TreeSet<String>  tree= new  TreeSet(new CompaerBay());
	 tree.add("a");
	 tree.add("aa");
	 tree.add("aaaa");
	 tree.add("cc");
	 tree.add("aaa");
	 tree.add("bb");
	
	
	 System.out.println(tree);
}


 public void testname01() {
	 TreeSet<Integer>  tree= new  TreeSet();
	 tree.add(4);
	 tree.add(4);
	 tree.add(14);
	 tree.add(14);
	 tree.add(40);
	 tree.add(40);
	 tree.add(2);
	 tree.add(2);
	 System.out.println(tree);
}
}


class  CompaerBay implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		//按照字符串的长度进行比较
		int num=o1.length()-o2.length();//主要对比条件
		//有的情况下num为0，O1和O2的字符串的长度是相同的
		return num==0?o1.compareTo(o2):num;//次要的条件
	}
	
	
	
	
}