package com.bjlemon.sys.expense.dao.imp;

import com.bjlemon.pojo.Cost;
import com.bjlemon.sys.expense.dao.ECostDao;
import com.bjlemon.utiles.C3p0Util;
import com.bjlemon.utiles.ThisCode;

import java.sql.SQLException;
import java.util.List;

public class CostDaoImp implements ECostDao {
    /**
     * 查询全部cost 并返回list对象 显示弹窗数据信息
     * @return
     */
    @Override
    public List<Cost> selectCost() {
        List<Cost> costs=null;
        String sql="select * from t_cost where costMark=? ";
        try {
          costs=C3p0Util.queryList(sql,Cost.class, ThisCode.OBJ_CODE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return costs;
    }
}
