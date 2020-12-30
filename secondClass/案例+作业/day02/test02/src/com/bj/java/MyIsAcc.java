
package com.bj.java;


/**
 * 断言的使用(平常判断XXXXX的使用)
 *    结合自定义异常来进行使用
 *    
 */
public class MyIsAcc {

	//获取自定义异常的方法
	  public  static  void  getMyThisRuntimeException(String message)throws  MyThisRuntimeException {
		  throw  new MyThisRuntimeException(message);
	  }
	  
	  
	  //判断某个字符串不能为空
	  //message  表示的是提示用的异常信息
	  //ages  需要进行断言(判断)某个字符串(数字...)
	  public  static  void  getIsNotNull(String message,String ages)throws MyThisRuntimeException {
		  if(ages==null || ages=="") {
			  	getMyThisRuntimeException(message);
		  }
	  }
	  
	  //不建议使用
	  public  static  void  $(String message,String ages)throws MyThisRuntimeException {
		  if(ages==null || ages=="") {
			  	getMyThisRuntimeException(message);
		  }
	  }
	  
	  
	  //假设哟200个Serivce都有着进行判断
	  //是不是要写200这种逻辑代码
	  public  void getSerivceImp() {
		  String  name=null;
		  if(name==null || name =="") {
			  //写上你业务逻辑代码
			  
		  }
		  
	  }
	  
	  
	
	  
	  //判断一个字符串不能为空
	  public  String  getTest(String st) {
		  if(st==null || st =="") {
			  return "不能使用该字符串";  
		  }
		  return "该字符串可以进行使用";
	  }
	  public  String  getTest01(String st) {
		  if(st==null || st =="") {
			  return "不能使用空密码";  
		  }
		  return "该密码可以进行使用";
	  }
	//假设有200个字符需要进行判断
	  //但是返回的信息是不一样的 是不是要进行创建200方法来进行返回
	  //不好,工作量大，还是不好维护  不便于二次开发 不便于阅读...
	  
	
	
}
