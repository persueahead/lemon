package com.jedis.po;

public class EmpInfo {

	private String empId;
	
	private String empName;
	
	private String empSex;
	
	private String EmpAge;
	
	private Dept dept;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public String getEmpAge() {
		return EmpAge;
	}

	public void setEmpAge(String empAge) {
		EmpAge = empAge;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmpInfo [empId=" + empId + ", empName=" + empName + ", empSex=" + empSex + ", EmpAge=" + EmpAge
				+ ", dept=" + dept + "]";
	}
	
	
}
