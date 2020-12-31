package com.bjlemon.maven;

import org.junit.Test;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName HelloworldTest.java
 * @Description TODO
 * @createTime 2020年02月29日 20:24:00
 */
public class HelloworldTest {

    @Test
    public void testSayHello() {
        System.out.println(new Helloworld().sayHello("Maven"));
    }
}
