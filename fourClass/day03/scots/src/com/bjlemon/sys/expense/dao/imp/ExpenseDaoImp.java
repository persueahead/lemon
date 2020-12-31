package com.bjlemon.sys.expense.dao.imp;

import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.bjlemon.sys.expense.dao.ExpenseDao;
import com.bjlemon.utiles.C3p0Util;
import com.bjlemon.utiles.ThisCode;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ExpenseDaoImp implements ExpenseDao {
    /**
     * 添加报销单
     * @param e
     * @return
     * @throws Exception
     */
    @Override
    public int addExpense(Expense e) throws Exception {
        Connection conn = null;
        int sum = 0;
        try {
            //     同时更改两张表 要使用事物 关闭自动提交
            conn = C3p0Util.getConn();
            conn.setAutoCommit(false);
//            sql语句 添加报销单             数据库detailMark设置了默认值
            String sql = "INSERT INTO t_expense(usersId ,expenseName,expenseDesc,expenseTotal,expenseDate,expenseState)\n" +
                    "VALUES(?,?,?,?,now(),?)";
            sum += C3p0Util.update(sql, e.getUsersId(), e.getExpenseName(), e.getExpenseDesc(), e.getExpenseTotal(), e.getExpenseState());
//            添加明细表
            String expenseId = "SELECT LAST_INSERT_ID()";
            int i = C3p0Util.getQr().query(expenseId, new ScalarHandler<BigInteger>()).intValue();
//          获取费用编号
            String costsIds[] = e.getCostIds();
//            明细详情描述
            String detailDescs[] = e.getDetailDescs();
//          明细金额
            Float[] detailMoneys = e.getDetailMoneys();
//          循环添加明细表数据 一行一个cosIsd 将每个报销单下的明细一行一行添加完
            for (int index = 0; index < costsIds.length; index++) {
//                数据库detailMark设置了默认值
                String sql2 = "INSERT INTO t_expense_detail(costId,expenseId,detailDesc,detailMoney) \n" +
                        "VALUES(?,?,?,?)";
                sum += C3p0Util.getQr().update(sql2, costsIds[index], i, detailDescs[index], detailMoneys[index]);
            }
//            所有数据添加完成后提交事物
            conn.commit();
//            自动提交改回来
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            conn.rollback();
            ex.printStackTrace();
        }

        System.out.println("sum=" + sum);
        return sum;
    }

    /**
     * 查询报销单
     * @param expense
     * @return
     * @throws Exception
     */
    @Override
    public List<Expense> selectExpense(Expense expense) throws Exception {
//      显然要条件查询 而且条件还有点多
//        用StringBuffer拼接
        StringBuffer stringBuffer = new StringBuffer(
                "SELECT u.usersName,e.* FROM t_expense e INNER JOIN t_users u \n" +
                "ON 1=1 \n" +
                "AND u.usersId=e.usersId \n"
                );
//        参数数组 参数类型为object 即不限定
        ArrayList<Object> arrayList=new ArrayList<>();
//        判断报销人姓名是否为空
        if (expense.getUsersName()!=null && !"".equals(expense.getUsersName())){
            stringBuffer.append(" AND u.usersName like ?");
            arrayList.add("%"+expense.getUsersName()+"%");
        }
//                  判断开始和结束时间
        if (expense.getStartDate()!=null && !"".equals(expense.getStartDate())){
            stringBuffer.append(" AND e.expenseDate>?");
            arrayList.add(expense.getStartDate());
        }
        if (expense.getEndDate()!=null && !"".equals(expense.getEndDate())){
            stringBuffer.append(" AND e.expenseDate<?");
            arrayList.add(expense.getEndDate());
        }
//         报销原因
        if (expense.getExpenseName()!=null && !"".equals(expense.getExpenseName())){
            stringBuffer.append(" AND e.expenseName like ?");
            arrayList.add("%"+expense.getExpenseName()+"%");
        }
 //        报销状态
        if (expense.getExpenseState()!=null && !"".equals(expense.getExpenseState())){
            stringBuffer.append(" AND e.expenseState = ?");
            arrayList.add(expense.getExpenseState());
        }
//        报销编号
        if (expense.getExpenseId()!=null && !"".equals(expense.getExpenseId())){
            stringBuffer.append(" AND e.expenseId = ?");
            arrayList.add(expense.getExpenseId());
        }
//        用户编号
        if (expense.getUsersId()!=null && !"".equals(expense.getUsersId())){
            stringBuffer.append(" AND e.usersId = ?");
            arrayList.add(expense.getUsersId());
        }
//      arrayList是集合 作为参数要转换成数组
       List<Expense> list= C3p0Util.queryList(stringBuffer.toString(),Expense.class,arrayList.toArray());
        return list;
    }

    /**
     * 查询报销明细
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<ExpenseDetail> selectCostDetailDao(int id) throws Exception {
        String sql="SELECT d.*,c.costName FROM t_expense_detail d INNER JOIN t_cost c ON d.costId=c.costId\n" +
                "AND d.expenseId=?\n";
//       返回多条包含报销明细的数据 每一行都是一个ExpenseDetail Bean
        return  C3p0Util.queryList(sql,ExpenseDetail.class,id);
    }

    /**
     * 修改报销单
     * @param expense
     * @return
     */
    @Override
    public int saveExpenseChangeDao(Expense expense) throws SQLException {
//        要对两张表进行操作 需要事物
        Connection conn = null;
        int sum = 0;
        try {
            //     同时更改两张表 要使用事物 关闭自动提交
            conn = C3p0Util.getConn();
            conn.setAutoCommit(false);
//          修改报销单
            String sql1 = "UPDATE t_expense e SET e.expenseName=?,e.expenseTotal=?,e.expenseDesc=?, e.expenseState=?  WHERE e.expenseId=?";
            sum+=C3p0Util.update(sql1, expense.getExpenseName(),expense.getExpenseTotal(),expense.getExpenseDesc(),expense.getExpenseState(),expense.getExpenseId());
//            修改明细表
            String[] costIds=expense.getCostIds();
            String[] detailDescs=expense.getDetailDescs();
            Float[] detailMoneys=expense.getDetailMoneys();
            String sql2="UPDATE t_expense_detail de set de.detailMoney=?,de.detailDesc=? WHERE de.costId=? AND de.expenseId=?";
            for (int i=0;i<costIds.length;i++){
                sum+=C3p0Util.update(sql2,detailMoneys[i],detailDescs[i],costIds[i],expense.getExpenseId());
            }

//            所有数据添加完成后提交事物
            conn.commit();
//            自动提交改回来
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            conn.rollback();
            ex.printStackTrace();
        }

        System.out.println("sum=" + sum);
        return sum;
    }
}
