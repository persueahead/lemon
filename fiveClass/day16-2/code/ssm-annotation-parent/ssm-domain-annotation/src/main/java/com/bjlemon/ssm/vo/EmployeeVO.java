package com.bjlemon.ssm.vo;

import com.bjlemon.ssm.domain.Department;
import com.bjlemon.ssm.domain.Employee;

public class EmployeeVO extends Employee {

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
