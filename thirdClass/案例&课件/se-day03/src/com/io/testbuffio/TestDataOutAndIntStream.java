package com.io.testbuffio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestDataOutAndIntStream {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          new TestDataOutAndIntStream().testname01();
	}

	/**
	 * 读
	 * @throws Exception
	 */
	public void testname01() throws Exception {
		DataInputStream  out=
				new DataInputStream(new FileInputStream("D:\\xxx\\oo\\拷贝XXXXXX.txt"));
		String str=out.readUTF();
		int i=out.readInt();
		System.out.println(str);
		System.out.println(i);
		
	}
	/**
	 * 数据流
	 * */
	public void testname() throws Exception {
		DataOutputStream out=
				new DataOutputStream(new FileOutputStream("D:\\xxx\\oo\\拷贝XXXXXX.txt"));
		out.writeUTF("隔壁老陈，你做坏事了");
		out.writeInt(12);
		out.flush();
		out.close();
	}
	
}
