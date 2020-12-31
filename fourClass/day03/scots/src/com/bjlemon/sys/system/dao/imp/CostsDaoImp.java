package com.bjlemon.sys.system.dao.imp;

import com.bjlemon.pojo.Cost;
import com.bjlemon.sys.system.dao.ICostDao;
import com.bjlemon.utiles.C3p0Util;
import com.bjlemon.utiles.ThisAssertion;
import com.bjlemon.utiles.ThisCode;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CostsDaoImp implements ICostDao {

    /**
     * 查询costs  返回list 集合
     * @param cost
     * @return
     * @throws Exception
     */
    @Override
    public List<Cost> selectListCosts(Cost cost) throws Exception {
        //        拼接字符串
        StringBuffer sql = new StringBuffer("SELECT c.* FROM t_cost  c  where  c.costMark=?");
//       用来装参数
        ArrayList<Object> objects = new ArrayList<>();
//        选取状态为0的
        objects.add(ThisCode.OBJ_CODE);

        //        使用if语句进行判断，条件查询    id是否有值 有就在sql上加上去
        if (cost.getCostId() != null && cost.getCostId() != 0) {
            sql.append("   AND c.costId=?");
            objects.add(cost.getCostId());

        }
//        if判断    条件查询  名称是否有值 有就在sql上加上去
        if (cost.getCostName() != null && !"".equals(cost.getCostName())) {
            sql.append("  AND c.costName LIKE  ?");
//            like模糊查询
            objects.add("%" + cost.getCostName() + "%");
        }
        //都没有 则就是SELECT u.*,r.roleName  FROM t_users  u  INNER JOIN  t_role  r ON  u.roleId=r.roleId    AND  u.usersMark=? 只需要一个参数
        return C3p0Util.queryList(sql.toString(), Cost.class, objects.toArray());
    }

    /**
     * 添加单个cost DDl无返回值 直接修改数据库
     * @param cost
     */
    @Override
    public int addCost(Cost cost) throws Exception {
    String sql="INSERT INTO t_cost  (costName,costDesc,costMark) VALUES(?,?,?)";
    int result=C3p0Util.update(sql,cost.getCostName(),cost.getCostDesc(),0);
    return result;
    }

    /**
     * 修改cost信息
     * @param cost
     * @return
     * @throws Exception
     */
    @Override
    public int updateCost(Cost cost) throws Exception {
//        以costId作为条件 更改costName和costDesc
        String sql="update t_cost set costName=?,costDesc=? where costId=?";
        int result=C3p0Util.update(sql,cost.getCostName(),cost.getCostDesc(),cost.getCostId());
        return result;
    }

    /**
     * 删除
     * @param cost
     * @return
     */
    @Override
    public int deleteCost(Cost cost) throws SQLException {
//        批量删除涉及事物 要关闭自动提交
//        获取连接 该接口由数据库厂商来实现
        Connection connection=null;
        int j=0;
        try{
           connection=C3p0Util.getConn();
            connection.setAutoCommit(false);
//            获取id数组 RequestBeanUtils将所有的name=ids的input的value至都装进了对应的ids[]数组里面
            Integer[] ids = cost.getIds();
            String sql="update t_cost set costMark=? where costId=?";
            for (int i = 0; i < ids.length; i++) {
                j = C3p0Util.update( sql, ThisCode.NO_CODE, ids[i]);
                ThisAssertion.isNotNumberNull("批量删除失败",j);
            }
            connection.commit();
            connection.setAutoCommit(true);
        }catch(Exception e){
            connection.rollback();
            e.printStackTrace();
        }
        return j;
    }
}
