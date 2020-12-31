package com.bjlemon.sys.expense.dao;

import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;

import java.sql.SQLException;
import java.util.List;

public interface ExpenseDao {
    int addExpense(Expense e) throws Exception;

    List<Expense> selectExpense(Expense expense) throws Exception;

    List<ExpenseDetail> selectCostDetailDao(int id) throws Exception;

    int saveExpenseChangeDao(Expense expense) throws SQLException;
}
