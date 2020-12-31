package com.bjlemon.sys.expense.service;

import com.bjlemon.pojo.AuditRecord;

import java.util.List;

public interface AuditService {
    /**
     * 添加auditRecord
     * @param auditRecord
     * @throws Exception
     */
    void addAuditRecord(AuditRecord auditRecord) throws Exception;

    /**
     * 查询完整auditBean
     * @param  recordExpenseId
     * @return
     */
    List<AuditRecord> selectAuditRecord(int recordExpenseId);

}
