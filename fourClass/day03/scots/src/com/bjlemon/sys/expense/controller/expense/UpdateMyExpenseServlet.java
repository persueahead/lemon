package com.bjlemon.sys.expense.controller.expense;

import com.bjlemon.pojo.AuditRecord;
import com.bjlemon.pojo.Cost;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.bjlemon.sys.expense.service.AuditService;
import com.bjlemon.sys.expense.service.ECostService;
import com.bjlemon.sys.expense.service.ExpenseService;
import com.bjlemon.sys.expense.service.imp.AuditServiceImp;
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

@WebServlet( "/expense/UpdateMyExpenseServlet")
public class UpdateMyExpenseServlet extends HttpServlet {
    //    cost相关方法
    ECostService ecostService=new ECostServiceImp();
    //    expense相关
    ExpenseService expenseService=new ExpenseServiceImp();
    AuditService auditService= new AuditServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//修改报销单
        try{
  //        Expense 能够装载提交的属性信息
            Expense expense = RequestBeanUtils.requestToBean(request, Expense.class);
//           完成对数据库的修改
            expenseService.saveExpenseChanges(expense);
//            显示更改后的数据--------------------------------------------------------
  //      cost 费用明细
            List<Cost> costs=ecostService.selectCosts();
            request.setAttribute("costs",costs);
            //         recordAudit   查审核记录--------------------------------------------------------------------------------------
            List<AuditRecord> recordList=auditService.selectAuditRecord(expense.getExpenseId());
            request.setAttribute("recordList",recordList);
//            查询expenseDetail--------------------------------------------------------------
            List<ExpenseDetail> detailList=expenseService.selectCostDetail(expense.getExpenseId());
            request.setAttribute("detailList",detailList);
//            expense
            List<Expense> expensesByIdList=expenseService.selectExpense(new Expense(expense.getExpenseId()));
            Expense e=expensesByIdList.get(0);
            request.setAttribute("expense",e);
//------------------------------------------------------
            request.setAttribute("tip","修改报销单成功");
//      get  跳转进行显示
            request.getRequestDispatcher("/view/expense/expense/expense_update.jsp").forward(request,response);
        }catch(Exception e){
            request.setAttribute("tip","修改报销单失败");
            request.getRequestDispatcher("/view/expense/expense/expense_update.jsp").forward(request,response);
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//通过a标签跳转修改页面 参数为expenseId 查询所有信息
        try{
           int expenseId= Integer.valueOf(request.getParameter("expenseId"));
  //      cost 费用明细
            List<Cost> costs=ecostService.selectCosts();
            request.setAttribute("costs",costs);
  //         recordAudit   查审核记录--------------------------------------------------------------------------------------
            List<AuditRecord> recordList=auditService.selectAuditRecord(expenseId);
            request.setAttribute("recordList",recordList);
//            查询expenseDetail--------------------------------------------------------------
            List<ExpenseDetail> detailList=expenseService.selectCostDetail(expenseId);
            request.setAttribute("detailList",detailList);
//            expense
            List<Expense> expensesByIdList=expenseService.selectExpense(new Expense(expenseId));
            Expense e=expensesByIdList.get(0);
            request.setAttribute("expense",e);
            request.getRequestDispatcher("/view/expense/expense/expense_update.jsp").forward(request,response );
        }catch(Exception e){
        e.printStackTrace();
        }



    }
}
