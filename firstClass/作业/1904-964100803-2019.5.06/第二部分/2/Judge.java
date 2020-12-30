package day5_06;

import java.util.Scanner;

public class Judge {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入一个正数");
			int number=sc.nextInt();
			if(number%2==0) {
				System.out.println("偶数");
			}else {
				System.out.println("奇数");
			}
	        sc.close();
	}

}
