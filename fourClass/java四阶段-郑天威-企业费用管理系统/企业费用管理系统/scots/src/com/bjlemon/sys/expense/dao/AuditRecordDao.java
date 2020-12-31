package com.bjlemon.sys.expense.dao;

import com.bjlemon.pojo.AuditRecord;

import java.util.List;

public interface AuditRecordDao {
    /**
     * 添加audit
     * @param auditRecord
     * @throws Exception
     */
    void addAuditRecord(AuditRecord auditRecord) throws Exception;

    /**
     * 查询audit，包括usersName
     * @param recordExpenseId
     * @return
     */
   List<AuditRecord> selectWoleAuditBeanDAO(int recordExpenseId);
}
