package com.nm.model;

/**
 * ��ְ��ʵ����
 * 
 * @author nmxy
 * 
 */
public class Teacher {

	private int teacherId;// ����
	private String teachername;// ����
	private String teacherSex;// �Ա�
	private int teacherAge;// ����
	private String teacherTel;// �绰
	private String teacherDept;// ϵ��
	private String teacherAddress;// ��ַ
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
