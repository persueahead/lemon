package com.bj.spring.imp;

import com.bj.spring.IUsersService;

public class UsersServiceImp implements IUsersService {
    @Override
    public void save() throws Exception {
        System.out.println("我执行 了添加的方法");

    }

    @Override
    public void del() throws Exception {
      //  System.out.println(1 / 0);
        System.out.println("我执行了删除的方法");

    }
}
