package com.bj.spring.test05;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Studnet implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println(method.getName() + "我被执行了");

        return null;
    }
}
