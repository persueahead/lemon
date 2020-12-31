package com.nm.model;

/**
 * 教职工实体类
 * 
 * @author nmxy
 * 
 */
public class Teacher {

	private int teacherId;// 工号
	private String teachername;// 姓名
	private String teacherSex;// 性别
	private int teacherAge;// 年龄
	private String teacherTel;// 电话
	private String teacherDept;// 系别
	private String teacherAddress;// 地址
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getTeacherSex() {
		return teacherSex;
	}
	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}
	public int getTeacherAge() {
		return teacherAge;
	}
	public void setTeacherAge(int teacherAge) {
		this.teacherAge = teacherAge;
	}
	public String getTeacherTel() {
		return teacherTel;
	}
	public void setTeacherTel(String teacherTel) {
		this.teacherTel = teacherTel;
	}
	public String getTeacherDept() {
		return teacherDept;
	}
	public void setTeacherDept(String teacherDept) {
		this.teacherDept = teacherDept;
	}
	public String getTeacherAddress() {
		return teacherAddress;
	}
	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teachername=" + teachername + ", teacherSex=" + teacherSex
				+ ", teacherAge=" + teacherAge + ", teacherTel=" + teacherTel + ", teacherDept=" + teacherDept
				+ ", teacherAddress=" + teacherAddress + "]";
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int teacherId, String teachername, String teacherSex, int teacherAge, String teacherTel,
			String teacherDept, String teacherAddress) {
		super();
		this.teacherId = teacherId;
		this.teachername = teachername;
		this.teacherSex = teacherSex;
		this.teacherAge = teacherAge;
		this.teacherTel = teacherTel;
		this.teacherDept = teacherDept;
		this.teacherAddress = teacherAddress;
	}
	
	
	
}
