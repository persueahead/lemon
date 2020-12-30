package com.bj.java;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class JavaTest {

	public static void name() throws UnknownHostException {
		InetAddress  iner=    InetAddress.getByName("www.baidu.com");
		System.out.println("名称"+iner);
		System.out.println("域名"+iner.getHostName());
		System.out.println("Ip"+iner.getHostAddress());
		//System.out.println("本机IP地址"+InetAddress.getLocalHost());
	}
	
	
	public static void main(String[] args) {
		try {
			name();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
