package com.bj.serivce.imp;

import com.bj.serivce.IStudentSerivce;

//目标对象
public class StudentSerivceImp implements IStudentSerivce {
    @Override
    public void save() throws Exception { //连接点
        //数据验证.方法
        System.out.println("我执行了,添加的方法");
        //进行调用对应的日志方法
    }

    @Override
    public void del() throws Exception {
         //数据验证.方法
        System.out.println(1 / 0);
        System.out.println("我运行了，删除的方法------");
        //进行调用对应的日志方法
    }
}
