package com.bjlemon.sys.finance.controller.salary;

import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;
import com.bjlemon.sys.finance.service.FinanceService;
import com.bjlemon.sys.finance.service.imp.FinanceServiceImp;
import com.bjlemon.sys.system.service.IUsersService;
import com.bjlemon.sys.system.service.impl.UsersServiceImp;
import com.bjlemon.utiles.MyDateFormat;
import com.my.web.servlet.RequestBeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet( "/salary/SelectSalaryListServlet")
public class SelectSalaryListServlet extends HttpServlet {
    FinanceService financeService=new FinanceServiceImp();
    IUsersService iUsersService=new UsersServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //         格式化时间        ConvertUtils.register 注册转换器，关于Date.class的转换 converter,将对象转为指定类型对象 MyDateFormat()将String转换成Date
        ConvertUtils.register(new MyDateFormat("yyyy-MM"), Date.class);
//           数据获取
       Salary salary= RequestBeanUtils.requestToSimpleBean(request,Salary.class);
        System.out.println(salary);
 //          查询薪资表
        List<Salary> salaries = null;
        try {
            salaries = financeService.selectSalaryList(salary);
            request.setAttribute("tip","查询成功");
            request.setAttribute("salaryList",salaries);
            request.setAttribute("salary",salary);
            request.getRequestDispatcher("/view/finance/salary/salarypayment_list.jsp").forward(request,response);
        } catch (Exception e) {
            request.setAttribute("tip","查询失败");
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
//          查询薪资表
            List<Salary> salaries = financeService.selectSalaryList(new Salary());
            request.setAttribute("salaryList",salaries);
            request.getRequestDispatcher("/view/finance/salary/salarypayment_list.jsp").forward(request,response);
        }catch(Exception e){
        e.printStackTrace();
        }
    }
}
