package com.bjlemon.sys.expense.controller.expense.audit;

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
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet( "/expense/DoManagerAudit")
public class DoManagerAuditServlet extends HttpServlet {
//    调用expense和auditRecord的相关方法
    ExpenseService expenseService=new ExpenseServiceImp();
    AuditService auditService=new AuditServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //        接收审核表数据进行审核 审核成功后还是这个页面
        //      打印获取的属性
        Enumeration<String> enumeration=request.getParameterNames();
        System.out.println("遍历枚举类型");
        while(enumeration.hasMoreElements()){
            String name=enumeration.nextElement();
            System.out.println("\t获取的属性名"+ name);
            System.out.println("\t获取的属性值"+ Arrays.toString(request.getParameterValues(name)));
        }
        try{
//            auditRecord也可以接收usersId和expenseId
            AuditRecord auditRecord=RequestBeanUtils.requestToBean(request,AuditRecord.class);
            System.out.println(auditRecord);
 //            添加审核记录 修改expense状态
            auditService.addAuditRecord(auditRecord);
//          查询expense基本信息-------------------------------------------------------------------------
            Expense expense=new Expense();
            expense.setExpenseId(auditRecord.getExpenseId());
//             调用之前的select方法 里面含有通过id查询expense 不过参数是expense的bean对象 所以用requestToBean封装接收jsp传递的参数
            List<Expense> expensesByIdList=expenseService.selectExpense(expense);
            Expense e=expensesByIdList.get(0);
            request.setAttribute("expense",e);
//            查询expenseDetail 报销单明细--------------------------------------------------------------
            List<ExpenseDetail> detailList=expenseService.selectCostDetail(auditRecord.getExpenseId());
            request.setAttribute("detailList",detailList);
//            查审核记录--------------------------------------------------------------------------------------
//            查询 所有 auditBean
            List<AuditRecord> recordList=auditService.selectAuditRecord(auditRecord.getExpenseId());
            request.setAttribute("recordList",recordList);
            request.setAttribute("tip","审核成功");
            request.getRequestDispatcher("/view/expense/managerAudit/expense_audit.jsp").forward(request,response);
        }catch(Exception e){
            request.setAttribute("tip","审核失败");
            request.getRequestDispatcher("/view/expense/managerAudit/expense_audit.jsp").forward(request,response);
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
 //        接收id并生成bean对象
            Expense expenseById= RequestBeanUtils.requestToBean(request,Expense.class);
            System.out.println("expenseById:"+expenseById);
//            查询基本信息
//             调用之前的select方法 里面含有通过id查询expense 不过参数是expense的bean对象 所以用requestToBean封装接收jsp传递的参数
            List<Expense> expensesByIdList=expenseService.selectExpense(expenseById);
            Expense e=expensesByIdList.get(0);
            request.setAttribute("expense",e);
//            查询expenseDetail 报销单明细--------------------------------------------------------------
            List<ExpenseDetail> detailList=expenseService.selectCostDetail(e.getExpenseId());
            request.setAttribute("detailList",detailList);
            request.getRequestDispatcher("/view/expense/managerAudit/expense_audit.jsp").forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
