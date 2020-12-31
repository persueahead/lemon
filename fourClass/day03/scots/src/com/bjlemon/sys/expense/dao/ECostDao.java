package com.bjlemon.sys.expense.dao;

import com.bjlemon.pojo.Cost;

import java.util.List;

public interface ECostDao {
    List<Cost> selectCost();
}
