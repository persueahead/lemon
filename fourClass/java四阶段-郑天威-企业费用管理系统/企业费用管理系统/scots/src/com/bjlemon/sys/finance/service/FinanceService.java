package com.bjlemon.sys.finance.service;

import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;
import com.bjlemon.sys.finance.dao.FinanceDao;
import com.bjlemon.sys.finance.dao.imp.FinanceDaoImp;

import java.util.List;

public interface FinanceService {
     /**
      * 查users编号和名字
      * @param users
      * @return
      * @throws Exception
      */
     List<Users> selectUsersName(Users users) throws Exception;

     /**
      * 添加薪资表
      * @param salary
      * @throws Exception
      */
     void addSalary(Salary salary) throws  Exception;

     /**
      * 查询薪资表
      * @param salary
      * @return
      */
     List<Salary> selectSalaryList(Salary salary) throws Exception;
}
