package com.bj.serivce;

import com.bj.serivce.imp.StudentSerivceImp;
import org.junit.Test;

public class TestProxy {


/**
 *
 */

@Test
public   void test001() throws Exception {
    //获取接口对象
    IStudentSerivce  iStudentSerivce=new StudentSerivceImp();
    //获取动态代理的工厂对象
    CglibProxyFactory  cglibProxyFactory=new CglibProxyFactory();
        //代理
    IStudentSerivce iStudentSerivceCglib = cglibProxyFactory.getIStudentSerivceCglib();
    iStudentSerivceCglib.save();
    iStudentSerivceCglib.del();
}



    @Test
    public   void test() throws Exception {
        //获取接口对象
        IStudentSerivce  iStudentSerivce=new StudentSerivceImp();
        //获取动态代理的工厂对象
        StudentSerivceProxyFactory  proxy=new StudentSerivceProxyFactory(iStudentSerivce);
        //获取动态代理的对象
        IStudentSerivce  iStudentSerivce1=   proxy.getIStudentSerivcePorxyFactory();
        iStudentSerivce1.del();
        iStudentSerivce1.save();
    }

}
