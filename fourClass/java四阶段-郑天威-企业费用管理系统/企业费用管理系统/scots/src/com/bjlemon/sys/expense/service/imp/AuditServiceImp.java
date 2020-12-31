package com.bjlemon.sys.expense.service.imp;

import com.bjlemon.pojo.AuditRecord;
import com.bjlemon.sys.expense.dao.AuditRecordDao;
import com.bjlemon.sys.expense.dao.imp.AuditRecordDaoImp;
import com.bjlemon.sys.expense.service.AuditService;

import java.util.ArrayList;
import java.util.List;

import static com.bjlemon.utiles.ThisCode.*;

public class AuditServiceImp implements AuditService {
    AuditRecordDao auditRecordDao=new AuditRecordDaoImp();
    @Override
    public void addAuditRecord(AuditRecord auditRecord) throws Exception {
        auditRecordDao.addAuditRecord(auditRecord);
    }

    @Override
    public List<AuditRecord> selectAuditRecord(int recordExpenseId) {
       List<AuditRecord> wholeAuditRecord=auditRecordDao.selectWoleAuditBeanDAO(recordExpenseId);
        ArrayList<AuditRecord> auditRecords=new ArrayList<>();
        for (AuditRecord a:wholeAuditRecord
        ) {
            if (a.getRecordState().equals(SAVE_OK)){
                a.setRecordStateHtml("<button type='button' class='btn btn-info'>保存已提交</button>");
            }
            if (a.getRecordState().equals(SAVE_NO)){
                a.setRecordStateHtml("<button type='button' class='btn btn-warning'>保存未提交</button>");
            }
            if (a.getRecordState().equals(MANAGER_OK)){
                a.setRecordStateHtml("<button type='button' class='btn btn-success'>经理审核通过</button>");
            }
            if (a.getRecordState().equals(MANAGER_NO)){
                a.setRecordStateHtml("<button type='button' class='btn btn-danger'>经理审核未通过</button>");
            }
            if (a.getRecordState().equals(FINANCE_OK)){
                a.setRecordStateHtml("<button type='button' class='btn btn-success'>财务审核通过o</button>");
            }
            if (a.getRecordState().equals(FINANCE_NO)){
                a.setRecordStateHtml("<button type='button' class='btn btn-danger'>财务审核未通过</button>");
            }
           auditRecords.add(a);
        }
        return auditRecords;
    }
}
