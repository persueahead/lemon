package com.bjlemon.sys.finance.service.imp;

import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;
import com.bjlemon.sys.finance.dao.FinanceDao;
import com.bjlemon.sys.finance.dao.imp.FinanceDaoImp;
import com.bjlemon.sys.finance.service.FinanceService;
import com.bjlemon.sys.system.service.IUsersService;
import com.bjlemon.sys.system.service.impl.UsersServiceImp;


import java.util.List;

public class FinanceServiceImp implements FinanceService {
    FinanceDao financedao=new FinanceDaoImp();
    IUsersService iUsersService=new UsersServiceImp();
    @Override
    public List<Users> selectUsersName(Users users) throws Exception {
         List<Users> usersList=financedao.selectUsers(users);
        return usersList;
    }

    /**
     * 添加薪资表
     * @throws Exception
     */
    @Override
    public void addSalary(Salary salary) throws Exception {
       financedao.addSalary(salary);

    }

    @Override
    public List<Salary> selectSalaryList(Salary salary) throws Exception {
       List<Salary> salaries=financedao.selectSalaryListDao(salary);
        return salaries;
    }
}
