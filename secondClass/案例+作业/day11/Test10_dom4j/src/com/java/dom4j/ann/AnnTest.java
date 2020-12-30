package com.java.dom4j.ann;

import java.io.PrintWriter;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class AnnTest extends Student{

	@Override
	public void getVoid() {
		// TODO Auto-generated method stub
		super.getVoid();
	}
	
	//压制警告的
	@SuppressWarnings({"unused","rawtypes"})
   private  ArrayList list=new ArrayList();
		   
	
}

class Student {
	
	@Deprecated//表示的过时,了但是可以进行使用的
	public void getVoid() {
		
		
	}
	
	
}