package com.bjlemon.utiles;

/**
 * 断言的类
 */
public class ThisAssertion {

   //获取自定义的异常方法
    /**
     * 、messgae 提示用户信息的
     */
    public  static  void  getThisException(final String messgae)throws  ThisExeption{
          throw  new ThisExeption(messgae);
    }



     /**
      * 断言一个字符串不能为空，为空就抛出异常 ，不为则返回该值，判断方法不需要对象接收
      *  messgae 提示用户信息的
      *  arage  进行断言的字符串
      */
     public static  String   isNotNull(final String message,String arage)throws  ThisExeption{
           if(arage==null  || (arage=arage.trim()).length()==0){
               getThisException(message);
           }
        return arage;
     }
    /**
     * 断言一个字符串为空，不为空就抛出异常
     *  messgae 提示用户信息的
     *  arage  进行断言的字符串
     */
    public static  String   isNull(final String message,String arage)throws  ThisExeption{
        if(arage!=null  || (arage=arage.trim()).length()>0){
            getThisException(message);
        }
        return arage;
    }

    /**
     * 断言数字不能为空 和 0 为 则抛出异常
     * @param message
     * @param arage
     * @return
     * @throws ThisExeption
     */
    public static  Integer   isNotNumberNull(final String message,Integer arage)throws  ThisExeption{
        if(arage==null  || arage==0){
            getThisException(message);
        }
        return arage;
    }

    public static void isFloatNotNull(String message, Float salaryComm) {
        if (salaryComm==0||salaryComm==null){
            getThisException(message);
        }
    }

    public static void markEquals1(String message, String usersMark) {
        if ("1".equals(usersMark)){
            getThisException(message);
        }
    }
}
