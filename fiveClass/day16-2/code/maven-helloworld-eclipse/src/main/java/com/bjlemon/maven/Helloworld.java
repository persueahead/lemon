package com.bjlemon.maven;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Hello world!
 *
 */
public class Helloworld {
	
	public String sayHello(String content) {
		String[] srcArray = {"IBM","SUN","Oracle"};
		String[] destArray = ArrayUtils.addAll(srcArray, "Google","Apple");
		System.out.println(Arrays.toString(destArray));
		
		return "Helloworld " + content;
	}
	
}
