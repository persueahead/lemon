package com.bj.java;

public class Test01 {

	public static void main(String[] args) {
		
		//�е�1560341543760  ������ʱ��    util.date 
       long  om= System.currentTimeMillis();//����    1970.1.1.0��0.0.0
       System.out.println(om);
       //˯��
       try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//�߳�
       long  om1= System.currentTimeMillis();//����    1970.1.1.0��0.0.0
       
       System.out.println(om1);
	}

}
