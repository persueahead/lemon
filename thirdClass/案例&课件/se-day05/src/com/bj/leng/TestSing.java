package com.bj.leng;

public class TestSing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singlet  s1=Singlet.getSinglet();
		Singlet  s2=Singlet.getSinglet();
		System.out.println(s1==s2);
	}

}


/**
 * 线程安全的
 */
class Singlet01{
	  private static Singlet01 s;
	private Singlet01() {
	}
	public  static synchronized Singlet01 getSinglet() {
		 if(s==null) {
			 s=new Singlet01();
		 }
		 return s;
	}
}


/**
 * 非线程安全的
 */
class  Singlet{

  private static Singlet s;
	
 private Singlet() 
 {}
 
 public  static Singlet getSinglet() {
	 System.out.println("-----------------");
	 if(s==null) {
		 s=new Singlet();
	 }
	 return s;
 }
}