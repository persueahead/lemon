package com.bj.serivce;

import com.bj.serivce.imp.StudentSerivceImp;
import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.prism.ReadbackRenderTarget;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {

    public  IStudentSerivce  getIStudentSerivceCglib(){
        //创建对象用于生成代理对象
        Enhancer enhancer = new Enhancer();
        //设置给谁进行代理
        enhancer.setSuperclass(StudentSerivceImp.class);
        //代理样进行做什么
        enhancer.setCallback(this);
        IStudentSerivce  iStudentSerivce=(IStudentSerivce)enhancer.create();

        return  iStudentSerivce;
    }



    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-------------执行数据验证---------------");

        //调用对应的方法
        Object o1 = methodProxy.invokeSuper(o, objects);

        System.out.println("-----------=-------------进行执行日志的方法--");

        return o1;
    }
}
