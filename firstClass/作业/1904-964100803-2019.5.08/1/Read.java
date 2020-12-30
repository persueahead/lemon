package day_06;

import java.util.Scanner;

public class Read {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入第一个整数");
		int a=sc.nextInt();
		System.out.println("输入第二个整数");
		int b=sc.nextInt();
		System.out.println("输入第三个整数");
		int c=sc.nextInt();
		sc.close();
		int max=a>b?a:b;
		max=max>c?max:c;
		System.out.println("最大值："+max);
		
	}
}
