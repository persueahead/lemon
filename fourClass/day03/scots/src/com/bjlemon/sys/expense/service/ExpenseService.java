package com.bjlemon.sys.expense.service;

import com.bjlemon.pojo.Expense;

import com.bjlemon.pojo.ExpenseDetail;

import java.util.List;

public interface ExpenseService {
    /**
     * 添加报销单
     * @param e
     * @return
     * @throws Exception
     */
    int addExpense(Expense e) throws Exception;

    /**
     * 查询报销明细
     * @return
     * @throws Exception
     */
    List<Expense> selectExpense(Expense expense) throws Exception;

    List<ExpenseDetail> selectCostDetail(int id) throws Exception;

    int saveExpenseChanges(Expense expense) throws Exception;
}
