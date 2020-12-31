package com.bjlemon.sys.expense.controller.expense;

import com.bjlemon.pojo.Cost;
import com.bjlemon.pojo.Expense;
import com.bjlemon.sys.expense.service.ECostService;
import com.bjlemon.sys.expense.service.ExpenseService;
import com.bjlemon.sys.expense.service.imp.ECostServiceImp;
import com.bjlemon.sys.expense.service.imp.ExpenseServiceImp;
import com.my.web.servlet.RequestBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/expense/ExpenseAddServlet")
public class ExpenseAddServlet extends HttpServlet {
//    cost相关方法
    ECostService ecostService=new ECostServiceImp();
//    expense相关
    ExpenseService expenseService=new ExpenseServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       获取表单数据
        Expense expense=RequestBeanUtils.requestToBean(request, Expense.class);

        try {
  //        修改数据库
            expenseService.addExpense(expense);
 //            重新查询cost内容,以供后续添加时要用
            List<Cost> costs=ecostService.selectCosts();
            request.setAttribute("costs",costs);
//            添加成功提示
            request.setAttribute("tip","报销单和明细表添加成功");
//            跳转回添加页面
            request.getRequestDispatcher("/view/expense/expense/expense_add.jsp").forward(request,response);

        } catch (Exception e) {
            request.setAttribute("tip","报销单和明细表添加失败");
            request.getRequestDispatcher("/view/expense/expense/expense_add.jsp").forward(request,response);
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
//      先把cost费用明细项目查询出来，以供在添加报销项目时选择项目下详细开销
        List<Cost> costs=ecostService.selectCosts();
        request.setAttribute("costs",costs);
//     get   跳转报销单添加页面
        request.getRequestDispatcher("/view/expense/expense/expense_add.jsp").forward(request,response);
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
