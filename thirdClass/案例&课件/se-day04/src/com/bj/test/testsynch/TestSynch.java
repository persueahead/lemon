package com.bj.test.testsynch;

public class TestSynch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TestSynch T=	new TestSynch();
		new Thread() {
			@Override
			public void run() {
				 while(true) {
					 try {
						T.testname();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}.start();
		new Thread() {
			@Override
			public void run() {
				 while(true) {
					 try {
						T.testname1();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}

	public void testname() throws Exception {
		System.out.print("同");
		System.out.print("学");
		System.out.print("们");
		System.out.print("天");
		System.out.print("天");
		System.out.print("向");
		System.out.print("上");
		System.out.println();
		System.out.print("同");
		System.out.print("学");
		System.out.print("们");
		System.out.print("天");
		System.out.print("天");
		System.out.print("向");
		System.out.print("上");
		System.out.println();
		
	}
	
	public void testname1() throws Exception {
		System.out.print("同");
		System.out.print("学");
		System.out.print("们");
		System.out.print("天");
		System.out.print("天");
		System.out.print("向");
		System.out.print("上");
		System.out.println();
		System.out.print("同");
		System.out.print("学");
		System.out.print("们");
		System.out.print("天");
		System.out.print("天");
		System.out.print("向");
		System.out.print("上");
		System.out.println();
		
	}
}
