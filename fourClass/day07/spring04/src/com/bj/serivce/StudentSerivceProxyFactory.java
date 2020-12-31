package com.bj.serivce;

import com.bj.serivce.imp.StudentSerivceImp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//进行创建动态代理的
public class StudentSerivceProxyFactory implements InvocationHandler {

    private  IStudentSerivce  iStudentSerivce;

    public StudentSerivceProxyFactory(IStudentSerivce iStudentSerivce) {
        this.iStudentSerivce = iStudentSerivce;
    }


    public  IStudentSerivce getIStudentSerivcePorxyFactory(){
        IStudentSerivce  iStudentSerivce=(IStudentSerivce) Proxy.newProxyInstance(
                StudentSerivceProxyFactory.class.getClassLoader(),
                StudentSerivceImp.class.getInterfaces(),this);
        return iStudentSerivce;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行数据验证
        System.out.println("=====---执行数据验证");  //通知
        Object invoke = method.invoke(iStudentSerivce, args);
        //进行执行日志的方法
        System.out.println("进行执行日志的方法------------------");  //通知

        return invoke;
    }
}
