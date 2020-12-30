package day_06;

import java.util.Scanner;

public class Freight{
	public static void main(String[] args) {
		float freight=0;
		System.out.println("输出货物重量（公斤）");
		Scanner sc=new Scanner (System.in);
		float weight=sc.nextFloat();
		if(0<=weight&&weight<=20) {
			freight=5;
		}else if(weight>20&&weight<=100) {
			freight=(float)(5+(weight-20)*0.2);
		}else if(weight>100) {
			freight=(float)(5+(weight-20)*0.15);
		}else {
			System.out.println("输入错误");
		}
		sc.close();
		System.out.println(freight);
	}
}
