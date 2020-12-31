package com.bjlemon.pojo;

public class Cost {
    /**
     * 消费编号
     */
    private Integer costId;
    /**
     *消费项目
     */
    private String  costName;
    /**
     *消费内容
     */
    private String costDesc;
    /**
     * 消费状态
     */
    private Integer costMark;
    /**
     * 手动拼接多选框
     */
    private String ck;
    /**
     *批量删除时获取所有编号
     */
    private  Integer[]  ids ;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    /**
     * 拼接ck多选框
     * @return
     */
    public String getCk() {
        ck="<INPUT TYPE='checkbox' value='"+getCostId()+"' name='ids' />";
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
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

    public String getCostDesc() {
        return costDesc;
    }

    public void setCostDesc(String costDesc) {
        this.costDesc = costDesc;
    }

    public Integer getCostMark() {
        return costMark;
    }

    public void setCostMark(Integer costMark) {
        this.costMark = costMark;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "costId=" + costId +
                ", costName='" + costName + '\'' +
                ", costDesc='" + costDesc + '\'' +
                ", costMark=" + costMark +
                '}';
    }
}
