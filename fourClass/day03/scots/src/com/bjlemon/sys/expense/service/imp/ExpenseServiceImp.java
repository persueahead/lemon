package com.bjlemon.sys.expense.service.imp;

import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.bjlemon.sys.expense.dao.ExpenseDao;
import com.bjlemon.sys.expense.dao.imp.ExpenseDaoImp;
import com.bjlemon.sys.expense.service.ExpenseService;
import com.bjlemon.utiles.ThisAssertion;
import static com.bjlemon.utiles.ThisCode.*;

import java.util.ArrayList;
import java.util.List;

public class ExpenseServiceImp implements ExpenseService {
    ExpenseDao expenseDao=new ExpenseDaoImp();
    @Override
    public int addExpense(Expense e) throws Exception {
        ThisAssertion.isNotNumberNull("报销人不能为空",e.getUsersId());
        ThisAssertion.isNotNull("报销原因不能为空",e.getExpenseName());
        ThisAssertion.isNotNull("报销详情不能为空",e.getExpenseDesc());
        int sum= expenseDao.addExpense(e);
        ThisAssertion.isNotNumberNull("事务执行不成功",sum);
       return sum;
    }

    @Override
    public List<Expense> selectExpense(Expense expense) throws Exception {
        List<Expense> list= expenseDao.selectExpense(expense);
//        新建一个集合用来接收设置stateHtml后的List<Expense>
        ArrayList<Expense> expensesIter=new ArrayList<>();
        for (Expense e:list
             ) {
            if (e.getExpenseState().equals(SAVE_OK)){
                e.setExpenseStateHtml("<button type='button' class='btn btn-info'>保存已提交</button>");
                e.setUpdateUrl("<a href='expense/UpdateMyExpenseServlet?expenseId="+e.getExpenseId()+"'>修改报销单</a>");
            }
            if (e.getExpenseState().equals(SAVE_NO)){
                e.setExpenseStateHtml("<button type='button' class='btn btn-warning'>保存未提交</button>");
                e.setUpdateUrl("<a href='expense/UpdateMyExpenseServlet?expenseId="+e.getExpenseId()+"'>修改报销单</a>");
            }
            if (e.getExpenseState().equals(MANAGER_OK)){
                e.setExpenseStateHtml("<button type='button' class='btn btn-success'>经理审核通过</button>");
                e.setFinanceAuditURL("<a href='financeAudit/DoFinanceAuditServlet?expenseId="+e.getExpenseId()+"'>财务审核</a>");
                e.setUpdateUrl("<a href='expense/UpdateMyExpenseServlet?expenseId="+e.getExpenseId()+"'>修改报销单</a>");
            }
            if (e.getExpenseState().equals(MANAGER_NO)){
                e.setExpenseStateHtml("<button type='button' class='btn btn-danger'>经理审核未通过</button>");
                e.setUpdateUrl("<a href='expense/UpdateMyExpenseServlet?expenseId="+e.getExpenseId()+"'>修改报销单</a>");
            }
            if (e.getExpenseState().equals(FINANCE_OK)){
                e.setExpenseStateHtml("<button type='button' class='btn btn-success'>财务审核通过</button>");
            }
            if (e.getExpenseState().equals(FINANCE_NO)){
                e.setExpenseStateHtml("<button type='button' class='btn btn-danger'>财务审核未通过</button>");
                e.setFinanceAuditURL("<a href='financeAudit/DoFinanceAuditServlet?expenseId="+e.getExpenseId()+"'>财务审核</a>");
                e.setUpdateUrl("<a href='expense/UpdateMyExpenseServlet?expenseId="+e.getExpenseId()+"'>修改报销单</a>");
            }
        expensesIter.add(e);
        }
//        返回设置了stateHtml后的lise
        return expensesIter;
    }

    @Override
    public List<ExpenseDetail> selectCostDetail(int id) throws Exception {
       List<ExpenseDetail> detailList= expenseDao.selectCostDetailDao(id);
        return detailList;
    }

    @Override
    public int saveExpenseChanges(Expense expense) throws Exception {
       int i= expenseDao.saveExpenseChangeDao(expense);
       ThisAssertion.isNotNumberNull("修改失败",i);
        return i;
    }
}
