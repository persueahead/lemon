package com.bjlemon.sys.system.service.impl;

import com.bjlemon.pojo.Cost;
import com.bjlemon.sys.system.dao.ICostDao;
import com.bjlemon.sys.system.dao.imp.CostsDaoImp;
import com.bjlemon.sys.system.service.IcostService;

import java.sql.SQLException;
import java.util.List;

public class CostServiceImp implements IcostService {
    ICostDao iCostDao= (ICostDao) new CostsDaoImp();

    /**
     * 查询cost
     * @param cost
     * @return
     * @throws Exception
     */
    @Override
    public List<Cost> selectCostList(Cost cost) throws Exception{
      List<Cost> costsList= iCostDao.selectListCosts(cost);
      return costsList;
    }

    /**
     * 添加cost
     * @param cost
     * @throws Exception
     */
    @Override
    public int addCost(Cost cost) throws Exception {
      int result= iCostDao.addCost(cost);
      return result;
    }

    /**
     * 更改
     * @param cost
     * @return
     * @throws Exception
     */
    @Override
    public int updateCost(Cost cost) throws Exception {
        int result=iCostDao.updateCost(cost);
        return  result;
    }

    /**
     * 删除
     * @param cost
     * @return
     */
    @Override
    public int deleteCost(Cost cost) throws SQLException {
       int result=iCostDao.deleteCost(cost);
       return result;
    }

}
