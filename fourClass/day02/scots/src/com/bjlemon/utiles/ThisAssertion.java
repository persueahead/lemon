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
      * 断言一个字符串不能为空
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
     * 断言一个字符串为空
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
     * 断言数字不能为空 和 0
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

}
