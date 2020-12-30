package day5_06;

import java.util.Scanner;

public class Judge {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入一个正数，判断是否为3和5的倍数");
			int number=sc.nextInt();
			if(number%3==0&&number%5==0) {
				System.out.println("是");
			}else {
				System.out.println("不是");
			}
	        sc.close();
	}

}
