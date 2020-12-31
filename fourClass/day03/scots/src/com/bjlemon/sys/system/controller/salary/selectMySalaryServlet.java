package com.bjlemon.sys.system.controller.salary;

import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.Users;
import com.bjlemon.sys.finance.service.FinanceService;
import com.bjlemon.sys.finance.service.imp.FinanceServiceImp;
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

@WebServlet( "/user/selectMySalaryServlet")
public class selectMySalaryServlet extends HttpServlet {
    FinanceService financeService=new FinanceServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        我的薪资查询，隐藏条件 是 “我的”
        //         格式化时间        ConvertUtils.register 注册转换器，关于Date.class的转换 converter,将对象转为指定类型对象 MyDateFormat()将String转换成Date
        ConvertUtils.register(new MyDateFormat("yyyy-MM"), Date.class);
//           数据获取
        Salary salary= RequestBeanUtils.requestToSimpleBean(request,Salary.class);
//        通过属性取得的是user对象
        Users user= (Users) request.getSession().getAttribute("users");
//        System.out.println(user);
        salary.setUsersId(user.getUsersId());
//        System.out.println("获取的salary条件"+salary);
        try {
            System.out.println("salary:");
            List<Salary> salaryList = financeService.selectSalaryList(salary);
            System.out.println(salaryList);
            request.setAttribute("salaryList",salaryList);
//            保留查询记录
            request.setAttribute("salary",salary);
            request.getRequestDispatcher("/view/system/user/salarypayment_mylist.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
