package com.department.manager.domain;

import java.io.Serializable;

/**
 * @author 夜神
 * @discription 员工部门
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 8561905745572868043L;
    private Integer depId;

    private String depName;

    private Integer depState;

    private String depDesc;

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public Integer getDepState() {
        return depState;
    }

    public void setDepState(Integer depState) {
        this.depState = depState;
    }

    public String getDepDesc() {
        return depDesc;
    }

    public void setDepDesc(String depDesc) {
        this.depDesc = depDesc == null ? null : depDesc.trim();
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", depState=" + depState +
                ", depDesc='" + depDesc + '\'' +
                '}';
    }
}