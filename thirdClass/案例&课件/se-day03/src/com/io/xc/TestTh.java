package com.io.xc;

public class TestTh {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
            new TestTh().testname();
	}

	
	public void testname() throws Exception {
		  for (int i = 0; i < 20; i++) {
			   new FileSize();
		}
		  for (int i = 0; i < 20; i++) {
			  System.out.println("我是主线程.................");
			  	System.gc();
		  }
		
	}
}

class  FileSize{

	@Override
	protected void finalize() throws Throwable {
		
		System.out.println("垃圾回收(清除).....");
	}
	    
	
}