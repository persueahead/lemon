package com.bjlemon.maven.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bjlemon.maven.Helloworld;

public class HelloworldTest {

	@Test
	public void test() {
		String result = new Helloworld().sayHello("Maven");
		System.out.println(result);
	}

}
