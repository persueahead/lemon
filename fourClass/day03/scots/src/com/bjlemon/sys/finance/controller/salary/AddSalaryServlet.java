package com.bjlemon.sys.finance.controller.salary;

import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;
import com.bjlemon.sys.finance.service.FinanceService;
import com.bjlemon.sys.finance.service.imp.FinanceServiceImp;
import com.bjlemon.utiles.C3p0Util;
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

@WebServlet("/salary/AddSalaryServlet")
public class AddSalaryServlet extends HttpServlet {
    FinanceService financeService=new FinanceServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
  //         格式化时间sql Date ——util Date        ConvertUtils.register 注册转换器，关于Date.class的转换 converter,将对象转为指定类型对象 MyDateFormat()将String转换成Date
        ConvertUtils.register(new MyDateFormat("yyyy-MM"), Date.class);
        Salary salary = RequestBeanUtils.requestToSimpleBean(request, Salary.class);
        System.out.println(salary);
//        添加薪资表
        financeService.addSalary(salary);
//        从新设置下拉框
        List<Users> usersList=financeService.selectUsersName(new Users());
        request.setAttribute("usersList",usersList);
//        跳转页面
        request.setAttribute("tip","添加薪资成功");
        request.getRequestDispatcher("/view/finance/salary/salarypayment_add.jsp").forward(request,response);
    }catch(Exception e){
        request.setAttribute("tip","添加薪资失败");
        request.getRequestDispatcher("/view/finance/salary/salarypayment_add.jsp").forward(request,response);
        e.printStackTrace();
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
//        跳转页面
            List<Users> usersList=financeService.selectUsersName(new Users());
            request.setAttribute("usersList",usersList);
            request.getRequestDispatcher("/view/finance/salary/salarypayment_add.jsp").forward(request,response);
        }catch(Exception e){
            request.setAttribute("tip","薪资发放页面跳转失败");
            request.getRequestDispatcher("/view/finance/salary/salarypayment_add.jsp").forward(request,response);
            e.printStackTrace();
        }
    }
}
