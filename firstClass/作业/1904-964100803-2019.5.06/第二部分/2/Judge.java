package day5_06;

import java.util.Scanner;

public class Judge {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("����һ������");
			int number=sc.nextInt();
			if(number%2==0) {
				System.out.println("ż��");
			}else {
				System.out.println("����");
			}
	        sc.close();
	}

}
