package com.bjlemon.sys.expense.service.imp;

import com.bjlemon.pojo.Cost;
import com.bjlemon.sys.expense.dao.ECostDao;
import com.bjlemon.sys.expense.dao.imp.CostDaoImp;
import com.bjlemon.sys.expense.service.ECostService;
import java.util.List;

public class ECostServiceImp implements ECostService {
    ECostDao ECostDao=new CostDaoImp();
    @Override
    public List<Cost> selectCosts() throws Exception {
        List<Cost> costs=ECostDao.selectCost();
        return costs;
    }
}
