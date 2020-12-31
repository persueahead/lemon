package com.bj.jdbc.dao;

import com.bj.jdbc.pojo.Users;

import java.util.List;

public interface IUsersDao {

    void   add (Users users);
    void   del (Users users);
    void   upeate (Users users);

    Users  getById(Integer id);

    int  getTotal();

    List<Users> getALL();
}
