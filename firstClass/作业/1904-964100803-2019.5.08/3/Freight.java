package day_06;

import java.util.Scanner;

public class Freight{
	public static void main(String[] args) {
		float freight=0;
		System.out.println("����������������");
		Scanner sc=new Scanner (System.in);
		float weight=sc.nextFloat();
		if(0<=weight&&weight<=20) {
			freight=5;
		}else if(weight>20&&weight<=100) {
			freight=(float)(5+(weight-20)*0.2);
		}else if(weight>100) {
			freight=(float)(5+(weight-20)*0.15);
		}else {
			System.out.println("�������");
		}
		sc.close();
		System.out.println(freight);
	}
}
