package com.exercise;

public class Resume {
  public static void main(String[] args) {
	  Person per=new Person();
	  per.name="֣����";
	  per.age =22;
	  per.gender="��";
	  per.qq=964100803;
	  per.wx="����";
	  per.mobilePhone=15897706156l;
	  per.emile="15897706156@163.com";
	  per.mainClass="�ź���ϵͳ��ͨ��ԭ��";
	  per.projectedExperience="����ϵͳ�ۺ����";
	  per.studyExperience="��ɽ�ص�һ�߼���ѧ����������ѧԺ";
	  per.print(); 
	 }
  }
class Person{
	String name;
	int age;
	String gender;
	int qq;
	long mobilePhone;
	String wx;
	String emile;
	String studyExperience;
	String mainClass;
	String projectedExperience;
	public void print() {
		System.out.println("������"+name);
		System.out.println("�Ա�"+gender);
		System.out.println("���䣺"+age);
		System.out.println("�绰��"+mobilePhone);
		System.out.println("QQ��"+qq);
		System.out.println("΢�ţ�"+wx);
		System.out.println("���䣺"+emile);
		System.out.println("ѧϰ������"+studyExperience);
		System.out.println("���޿γ̣�"+mainClass);
		System.out.println("��Ŀ���飺"+projectedExperience);
	}
	
}