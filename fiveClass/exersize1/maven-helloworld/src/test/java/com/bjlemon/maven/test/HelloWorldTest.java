package com.bjlemon.maven.test;

import com.bjlemon.maven.*;
import org.junit.*;


@Test
public void testSayHellow() {
    HelloWorld hello= new HelloWorld();
    String result= hello.sayHello("maven");
    System.out.println(result);
}

