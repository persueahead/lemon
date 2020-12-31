package com.bjlemon.maven.test;

import com.bjlemon.maven.*;
import org.junit.*;


public class HelloworldTest {

    @Test 
    public void testSayHello() {
        Helloworld helloworld = new Helloworld();
        String result = helloworld.sayHello("Maven");
        System.out.println(result);
    }
}