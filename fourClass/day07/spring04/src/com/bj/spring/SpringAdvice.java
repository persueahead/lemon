package com.bj.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//标识当前类为通知类
@Aspect
public class SpringAdvice {

    @Pointcut("execution(  * com.bj.spring.imp.*ServiceImp.*(..))")
    public   void   pt(){

    }


    @Before("SpringAdvice.pt()")
     public  void  getBefore(){
         System.out.println("前置通知---");

     }

     @After("SpringAdvice.pt()")
     public  void  getAfter(){
         System.out.println("最终通知");
     }


     @Around("execution(  * com.bj.spring.imp.*ServiceImp.*(..))")
     public  Object getAround(ProceedingJoinPoint  pj)throws  Throwable{
         System.out.println("环绕通知前----执行方法---------");

         Object proceed = pj.proceed();//调用目标方法

         System.out.println("环绕通知前后=========----执行方法---------");

         return  proceed;
     }

     @AfterThrowing("execution(  * com.bj.spring.imp.*ServiceImp.*(..))")
     public  void  getExcption(){
         System.out.println("异常通知-----");

     }
     @AfterReturning("execution(  * com.bj.spring.imp.*ServiceImp.*(..))")
     public  void  getAfterExceptino(){

         System.out.println("后置通知");

     }
}
