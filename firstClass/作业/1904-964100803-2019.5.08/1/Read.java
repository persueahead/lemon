package day_06;

import java.util.Scanner;

public class Read {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�����һ������");
		int a=sc.nextInt();
		System.out.println("����ڶ�������");
		int b=sc.nextInt();
		System.out.println("�������������");
		int c=sc.nextInt();
		sc.close();
		int max=a>b?a:b;
		max=max>c?max:c;
		System.out.println("���ֵ��"+max);
		
	}
}
