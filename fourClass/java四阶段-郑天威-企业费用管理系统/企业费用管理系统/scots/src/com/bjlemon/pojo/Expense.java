package com.bjlemon.pojo;

import java.util.Arrays;
import java.util.Date;

public class Expense {
    /**
     * 报销id
     */
    private Integer expenseId;
    /**
     * 报销人员id
     */
    private Integer usersId;
    /**
     * 报销人名称
     */
    private String usersName;
    /**
     * 报销项目
     */
    private String expenseName;
    /**
     * 报销内容
     */
    private String expenseDesc;
    /**
     * 报销总金额
     */
    private Float expenseTotal;
    /**
     * 报销日期
     */
    private Date expenseDate;
    /**
     * 提交状态
     */
    private String expenseState;
    /**
     * 状态码html解释拼接
     */
    private String expenseStateHtml;
    /**
     * 报销状态
     */
    private String expenseMark;
    /**
     * 审核跳转地址
     */
    private String expenseAuditUrl;
    /**
     * 财务审核url
     */
    private String financeAuditURL;
    /**
     * 修改报销单跳转地址
     */
    private String updateUrl;
    /**
     * 多选明细编号
     */
    private String costIds[];
    /**
     * 明细金额
     */
    private Float detailMoneys[];
    /**
     * 明细描述
     */
    private String detailDescs[];
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;

    public Expense() {
        super();
    }

    public Expense(Integer expenseId) {
        super();
        this.expenseId = expenseId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", usersId=" + usersId +
                ", usersName='" + usersName + '\'' +
                ", expenseName='" + expenseName + '\'' +
                ", expenseDesc='" + expenseDesc + '\'' +
                ", expenseTotal=" + expenseTotal +
                ", expenseDate=" + expenseDate +
                ", expenseState='" + expenseState + '\'' +
                ", expenseStateHtml='" + expenseStateHtml + '\'' +
                ", expenseMark='" + expenseMark + '\'' +
                ", expenseAuditUrl='" + expenseAuditUrl + '\'' +
                ", financeAuditURL='" + financeAuditURL + '\'' +
                ", updateUrl='" + updateUrl + '\'' +
                ", costIds=" + Arrays.toString(costIds) +
                ", detailMoneys=" + Arrays.toString(detailMoneys) +
                ", detailDescs=" + Arrays.toString(detailDescs) +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getFinanceAuditURL() {
        return financeAuditURL;
    }

    public void setFinanceAuditURL(String financeAuditURL) {
        this.financeAuditURL = financeAuditURL;
    }

    public String getExpenseAuditUrl() {
        return expenseAuditUrl;
    }

    public void setExpenseAuditUrl(String expenseAuditUrl) {
        this.expenseAuditUrl = expenseAuditUrl;
    }

    public String getExpenseStateHtml() {
        return expenseStateHtml;
    }

    public void setExpenseStateHtml(String expenseStateHtml) {
        this.expenseStateHtml = expenseStateHtml;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseDesc() {
        return expenseDesc;
    }

    public void setExpenseDesc(String expenseDesc) {
        this.expenseDesc = expenseDesc;
    }

    public Float getExpenseTotal() {
        return expenseTotal;
    }

    public void setExpenseTotal(Float expenseTotal) {
        this.expenseTotal = expenseTotal;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseState() {
        return expenseState;
    }

    public void setExpenseState(String expenseState) {
        this.expenseState = expenseState;
    }

    public String getExpenseMark() {
        return expenseMark;
    }

    public void setExpenseMark(String expenseMark) {
        this.expenseMark = expenseMark;
    }

    public String[] getCostIds() {
        return costIds;
    }

    public void setCostIds(String[] costIds) {
        this.costIds = costIds;
    }

    public Float[] getDetailMoneys() {
        return detailMoneys;
    }

    public void setDetailMoneys(Float[] detailMoneys) {
        this.detailMoneys = detailMoneys;
    }

    public String[] getDetailDescs() {
        return detailDescs;
    }

    public void setDetailDescs(String[] detailDescs) {
        this.detailDescs = detailDescs;
    }


}
