package com.bjlemon.sys.finance.dao;

import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;

import java.util.List;

public interface FinanceDao {

    List<Users> selectUsers(Users users) throws Exception;

    void addSalary(Salary salary) throws Exception;

    List<Salary> selectSalaryListDao(Salary salary) throws Exception;
}
