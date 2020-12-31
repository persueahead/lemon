package com.bjlemon.sys.expense.service;

import com.bjlemon.pojo.Cost;

import java.util.List;

public interface ECostService {
//    查询全部cost信息
    List<Cost> selectCosts() throws Exception;
}
