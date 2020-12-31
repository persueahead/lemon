package com.bjlemon.sys.expense.controller.expense;

import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.Users;
import com.bjlemon.sys.expense.service.ExpenseService;
import com.bjlemon.sys.expense.service.imp.ExpenseServiceImp;
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

@WebServlet( "/expense/MyExpenseServlet")
public class MyExpenseServlet extends HttpServlet {
    ExpenseService expenseService=new ExpenseServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
        ConvertUtils.register(new MyDateFormat(), Date.class);
//           数据获取
        Expense expense= RequestBeanUtils.requestToSimpleBean(request,Expense.class);
        Users users = (Users) request.getSession().getAttribute("users");
        expense.setUsersId(users.getUsersId());
        System.out.println(expense);
//          用接收到的信息查询数据库,显示查询结果expenseId userName expenseNam expenseDate expenseState expenseTotal
//                            点击查看详情时，携带expenseId跳转servlet
        List<Expense> list= expenseService.selectExpense(expense);
        System.out.println(list);
//           保存查询痕迹
        request.setAttribute("expense",expense);
//            显示查询结果
        request.setAttribute("list",list);
        request.getRequestDispatcher("/view/expense/expense/expense_mylist.jsp").forward(request,response);
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
