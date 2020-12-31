package com.bjlemon.sys.expense.dao.imp;

import com.bjlemon.pojo.AuditRecord;
import com.bjlemon.sys.expense.dao.AuditRecordDao;
import com.bjlemon.utiles.C3p0Util;
import com.bjlemon.utiles.ThisAssertion;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

public class AuditRecordDaoImp implements AuditRecordDao {
    /**
     * 添加审核记录表
     * @param auditRecord
     * @throws Exception
     */
    @Override
    public void addAuditRecord(AuditRecord auditRecord) throws Exception {
//        既需要添加审核记录又需要修改expenseState 多个操作 需要事物来完成
        Connection connection=null;
        int i=0;
        try{
            connection= C3p0Util.getConn();
            connection.setAutoCommit(false);
            QueryRunner queryRunner=C3p0Util.getQr();
//            添加审核记录
            String sqlToRecord="INSERT INTO t_audit_record(usersId ,expenseId,recordState,recordSugg,recordDate)\n" +
                    "VALUES(?,?,?,?,NOW())";
           i+= queryRunner.update(sqlToRecord,auditRecord.getUsersId(),auditRecord.getExpenseId(),auditRecord.getRecordState(),
                                    auditRecord.getRecordSugg());
//           修改expense状态
            String sqlToExpense="UPDATE t_expense e SET e.expenseState=? WHERE e.expenseId=? ";
            i+=queryRunner.update(sqlToExpense,auditRecord.getRecordState(),auditRecord.getExpenseId());

            ThisAssertion.isNotNumberNull("审核失败，数据库信息添加失败",i);

            connection.commit();
            connection.setAutoCommit(true);
        }catch(Exception e){
            connection.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<AuditRecord> selectWoleAuditBeanDAO(int recordExpenseId) {
        String sql="SELECT u.usersName,r.* FROM t_audit_record r INNER JOIN t_users u ON u.usersId=r.usersId \n" +
                "AND r.expenseId=?";
        List<AuditRecord> WholeRecord=null;
        try {
            WholeRecord=C3p0Util.queryList(sql,AuditRecord.class,recordExpenseId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return WholeRecord;
    }
}
