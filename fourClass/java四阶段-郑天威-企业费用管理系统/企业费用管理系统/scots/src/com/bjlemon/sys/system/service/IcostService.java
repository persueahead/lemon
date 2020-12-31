package com.bjlemon.sys.system.service;

import com.bjlemon.pojo.Cost;

import java.sql.SQLException;
import java.util.List;

public interface IcostService {
    /**
     * 查cost
     * @param cost
     * @return
     * @throws Exception
     */
    List<Cost> selectCostList(Cost cost) throws Exception;

    /**
     * 添加
     * @param cost
     * @return
     * @throws Exception
     */
    int addCost(Cost cost) throws Exception;

    /**
     * 更改
     * @param cost
     * @return
     * @throws Exception
     */
    int updateCost(Cost cost) throws Exception;

    /**
     * 删除
     * @param cost
     * @return
     */
    int deleteCost(Cost cost) throws SQLException;
}
