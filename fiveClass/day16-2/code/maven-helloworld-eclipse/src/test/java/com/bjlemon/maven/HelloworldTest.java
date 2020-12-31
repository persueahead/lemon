package com.bjlemon.maven;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class HelloworldTest {

	@Test
	public void testSayHello() {
		String result = new Helloworld().sayHello("Maven");
		System.out.println(result);
	}
}
