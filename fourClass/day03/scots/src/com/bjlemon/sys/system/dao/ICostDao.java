package com.bjlemon.sys.system.dao;

import com.bjlemon.pojo.Cost;

import java.sql.SQLException;
import java.util.List;

public interface ICostDao {
    /**
     * 查询costs
     * @param cost
     * @return
     * @throws Exception
     */
    List<Cost> selectListCosts(Cost cost) throws Exception;

    /**
     * 添加cost 一次只能添加一个
     * @param cost
     */
    int addCost(Cost cost) throws Exception;

    /**
     * 修改cost信息
     * @param cost
     * @return
     */
    int updateCost(Cost cost) throws Exception;

    /**
     * 删除
     * @param cost
     * @return
     */
    int deleteCost(Cost cost) throws SQLException;
}
