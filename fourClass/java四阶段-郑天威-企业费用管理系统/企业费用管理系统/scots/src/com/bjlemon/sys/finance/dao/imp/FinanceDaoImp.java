package com.bjlemon.sys.finance.dao.imp;

import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;
import com.bjlemon.sys.finance.dao.FinanceDao;
import com.bjlemon.sys.system.service.IUsersService;
import com.bjlemon.sys.system.service.impl.UsersServiceImp;
import com.bjlemon.utiles.C3p0Util;
import com.bjlemon.utiles.ThisAssertion;
import com.bjlemon.utiles.ThisCode;

import java.util.ArrayList;
import java.util.List;

public class FinanceDaoImp implements FinanceDao {
    /**
     * 查询 领取人usersName
     * @return
     * @throws Exception
     */
    @Override
    public List<Users> selectUsers(Users users) throws Exception {
        String sql="SELECT u.usersName,u.usersId FROM t_users u WHERE u.usersMark!=? ";
        List<Users> usersList = C3p0Util.queryList(sql, Users.class, ThisCode.NO_CODE);
        return usersList;
    }

    /**
     * 添加薪资表
     * @param salary
     * @throws Exception
     */
    @Override
    public void addSalary(Salary salary) throws Exception {
//        String sql="INSERT INTO t_salary_record  \n" +
//                "VALUES(salaryId,?,?,NOW(),?,?)";
        String sql="INSERT INTO t_salary_record(usersId,salaryMonth,salaryDate,salaryBasic,salaryComm) \n" +
                "VALUES(?,?,NOW(),?,?)";
        ThisAssertion.isFloatNotNull("奖金不能为零",salary.getSalaryComm());
       int i= C3p0Util.update(sql,salary.getUsersId(),salary.getSalaryMonth(),salary.getSalaryBasic(),salary.getSalaryComm());
       ThisAssertion.isNotNumberNull("添加失败",i);
    }

    /**
     * 条件查询薪资表
     * @param salary
     * @return
     * @throws Exception
     */
    @Override
    public List<Salary> selectSalaryListDao(Salary salary) throws Exception {
        Users users1 =null;
//      如果查询用户不为空 判断用户是否存在
        if (salary.getUsersName()!=null&&!"".equals(salary.getUsersName())) {
            IUsersService iUsersService = new UsersServiceImp();
            Users users = new Users();
            users.setUsersName(salary.getUsersName());
//        获取usersId
             users1 = iUsersService.selectListUsers(users).get(0);
            ThisAssertion.markEquals1("查询用户已删除",users1.getUsersMark());
//            有名字才能查id
        }
// 用多表联查更快捷方便 在联查的表上使用条件查询

        String sql="SELECT s.*,u.usersName FROM t_salary_record s INNER JOIN t_users u WHERE s.usersId=u.usersId\n ";
        StringBuffer buffer=new StringBuffer(sql);
        ArrayList<Object> parametersList=new ArrayList<>();

        if(salary.getUsersName()!=null&&!"".equals(salary.getUsersName())){
            buffer.append(" AND u.usersName like ?");
            parametersList.add("%"+salary.getUsersName()+"%");
        }
        if (salary.getSalaryMonth()!=null&&!"".equals(salary.getSalaryMonth())){
            buffer.append(" AND s.salaryMonth=?");
            parametersList.add(salary.getSalaryMonth());
        }
        if (salary.getUsersId()!=null&&0!=salary.getUsersId()){
            buffer.append(" AND s.usersId=?");
            parametersList.add(salary.getUsersId());
        }

//        当查询用户名为空且时间为空时查询的是所有薪资表
//        当有一个不为空 查询的是对应的
         List<Salary> salaryList=   C3p0Util.queryList(buffer.toString(),Salary.class,parametersList.toArray());
        return salaryList;
    }
}
