package day_06;

import java.util.Scanner;

public class GuessGame {
	public static void main(String[] args) {
	int number=(int)(Math.random()*100)+1;
	System.out.println("��һ������");
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	int flag=1;
	do {
			if(num>number) {
			System.out.println("����,��������");
		}else {
			System.out.println("С�ˣ���������");
		}
			flag++;
			if(flag>3) {
			System.out.println("����������࣬��Ϸ����");
			return;
			}
			num=sc.nextInt();
			}while(num==number);
	sc.close();
	System.out.println(num);
	System.out.println(flag);
}
}
