package com.bj.serivce.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/*
* 2.通知分为以下通知
    |-前置通知
       目标方法运行前进行调用
  |-后置通知
        标方法运行后进行调用的
   |-异常通知
         目标方法出现异常就会运行的通知
   |-最终通知
          1.无论是否出现异常，那么都会进行执行
          2.目标方法之后进行运行的方法
   |-环绕通知
         目标方法运行前后进行调用的通知
* */
public class SpringAdvice {
     public  void  getBefore(){
         System.out.println("前置通知---");

     }

     public  void  getAfter(){
         System.out.println("最终通知");
     }


     public  Object getAround(ProceedingJoinPoint  pj)throws  Throwable{
         System.out.println("环绕通知前----执行方法---------");

         Object proceed = pj.proceed();//调用目标方法

         System.out.println("环绕通知前后=========----执行方法---------");

         return  proceed;
     }

     public  void  getExcption(){
         System.out.println("异常通知-----");

     }
     public  void  getAfterExceptino(){

         System.out.println("后置通知");

     }
}
