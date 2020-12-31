package com.bjlemon.sys.expense.controller.expense;


import com.bjlemon.pojo.AuditRecord;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.bjlemon.sys.expense.service.AuditService;
import com.bjlemon.sys.expense.service.ExpenseService;
import com.bjlemon.sys.expense.service.imp.AuditServiceImp;
import com.bjlemon.sys.expense.service.imp.ExpenseServiceImp;
import com.my.web.servlet.RequestBeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet( "/expense/showExpenseDetail")
public class ExpenseShowServlet extends HttpServlet {
    ExpenseService expenseService=new ExpenseServiceImp();
    AuditService auditService=new AuditServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
 //        接收id并生成bean对象
            Expense expenseById= RequestBeanUtils.requestToBean(request,Expense.class);
//             调用之前的select方法 里面含有通过id查询expense 不过参数是expense的bean对象 所以用requestToBean封装接收jsp传递的参数
            List<Expense> expensesByIdList=expenseService.selectExpense(expenseById);
            Expense e=expensesByIdList.get(0);
            request.setAttribute("expense",e);
//            查询expenseDetail--------------------------------------------------------------
            List<ExpenseDetail> detailList=expenseService.selectCostDetail(e.getExpenseId());
            request.setAttribute("detailList",detailList);
//            查询历史纪录编号
            List<AuditRecord> recordList=auditService.selectAuditRecord(e.getExpenseId());
            request.setAttribute("recordList",recordList);
//            转发显示页
            request.getRequestDispatcher("/view/expense/expense/expense_show.jsp").forward(request,response);

        } catch (Exception e) {
            request.setAttribute("tip","查看失败");
 //            转发显示页
            request.getRequestDispatcher("/view/expense/expense/expense_show.jsp").forward(request,response);
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
