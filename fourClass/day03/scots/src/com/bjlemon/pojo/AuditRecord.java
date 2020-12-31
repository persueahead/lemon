package com.bjlemon.pojo;

import java.util.Date;

public class AuditRecord {
    /**
     * 审核记录id
     */
    private Integer recordId;
    /**
     * 审核人编号
     */
    private Integer usersId;
    /**
     * 审核人姓名
     */
    private String usersName;
    /**
     * 审核的报销id
     */
    private Integer expenseId;
    /**
     * 审核状态
     */
    private String recordState;
    /**
     *
     */
    private String recordStateHtml;
    /**
     * 审核描述
     */
    private String recordSugg;
    /**
     * 审核日期
     */
    private Date recordDate;

    @Override
    public String toString() {
        return "AuditRecord{" +
                "recordId=" + recordId +
                ", usersId=" + usersId +
                ", usersName='" + usersName + '\'' +
                ", expenseId=" + expenseId +
                ", recordState='" + recordState + '\'' +
                ", recordStateHtml='" + recordStateHtml + '\'' +
                ", recordSugg='" + recordSugg + '\'' +
                ", recordDate=" + recordDate +
                '}';
    }

    public String getRecordStateHtml() {
        return recordStateHtml;
    }

    public void setRecordStateHtml(String recordStateHtml) {
        this.recordStateHtml = recordStateHtml;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public String getRecordState() {
        return recordState;
    }

    public void setRecordState(String recordState) {
        this.recordState = recordState;
    }

    public String getRecordSugg() {
        return recordSugg;
    }

    public void setRecordSugg(String recordSugg) {
        this.recordSugg = recordSugg;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
}
