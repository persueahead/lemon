package com.bjlemon.pojo;

import java.util.Date;

public class Salary {
    /**
     * 薪资单id
     */
    private Integer salaryId;
    /**
     * 领取人id
     */
    private Integer usersId;
    /**
     * 领取人姓名
     */
    private String usersName;
    /**
     * 领取月份
     */
    private Date salaryMonth;
    /**
     * 领取日期
     */
    private Date salaryDate;
    /**
     * 底薪
     */
    private Float salaryBasic;
    /**
     * 提成
     */
    private Float salaryComm;


    @Override
    public String toString() {
        return "Salary{" +
                "salaryId=" + salaryId +
                ", usersId=" + usersId +
                ", usersName='" + usersName + '\'' +
                ", salaryMonth=" + salaryMonth +
                ", salaryDate=" + salaryDate +
                ", salaryBasic=" + salaryBasic +
                ", salaryComm=" + salaryComm +
                '}';
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Date getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(Date salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

    public Float getSalaryBasic() {
        return salaryBasic;
    }

    public void setSalaryBasic(Float salaryBasic) {
        this.salaryBasic = salaryBasic;
    }

    public Float getSalaryComm() {
        return salaryComm;
    }

    public void setSalaryComm(Float salaryComm) {
        this.salaryComm = salaryComm;
    }
}
