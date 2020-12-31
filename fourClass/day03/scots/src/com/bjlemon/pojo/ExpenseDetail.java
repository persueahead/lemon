package com.bjlemon.pojo;

public class ExpenseDetail {
    /**
     * 明细编号
     */
    private Integer detailId;
    /**
     * 费用编号
     */
    private Integer costId;
    /**
     * 费用名称
     */
    private String  costName;
    /**
     * 报销编号
     */
    private Integer expenseId;
    /**
     * 明细描述
     */
    private String detailDesc;
    /**
     * 明细金额
     */
    private Float detailMoney;
    /**
     * 明细可用标识
     */
    private String detailMark;

    @Override
    public String toString() {
        return "expenseDetail{" +
                "detailId=" + detailId +
                ", costId=" + costId +
                ", costName='" + costName + '\'' +
                ", expenseId=" + expenseId +
                ", detailDesc='" + detailDesc + '\'' +
                ", detailMoney=" + detailMoney +
                ", detailMark='" + detailMark + '\'' +
                '}';
    }

    public ExpenseDetail() {
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public Float getDetailMoney() {
        return detailMoney;
    }

    public void setDetailMoney(Float detailMoney) {
        this.detailMoney = detailMoney;
    }

    public String getDetailMark() {
        return detailMark;
    }

    public void setDetailMark(String detailMark) {
        this.detailMark = detailMark;
    }
}
