package day5_06;

import java.util.Scanner;

public class JudgeAge {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��������");
			int age=sc.nextInt();
			if(age>50) {
				System.out.println("������");
			}else if(18<age&age<35) {
				System.out.println("����");
			}else if(14<age&&age<17) {
				System.out.println("������");
			}else if(age>6&&age<13) {
				System.out.println("�ٶ�");
			}else if(age>=0&&age<6){
				System.out.println("��ͯ");
			}else {
				System.out.println("������������");
			}
	    sc.close();
	}

}
