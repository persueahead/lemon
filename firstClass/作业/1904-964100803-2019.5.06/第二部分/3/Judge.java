package day5_06;

import java.util.Scanner;

public class Judge {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("����һ���������ж��Ƿ�Ϊ3��5�ı���");
			int number=sc.nextInt();
			if(number%3==0&&number%5==0) {
				System.out.println("��");
			}else {
				System.out.println("����");
			}
	        sc.close();
	}

}
