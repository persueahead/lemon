package day_06;

import java.util.Scanner;

public class GuessGame {
	public static void main(String[] args) {
	int number=(int)(Math.random()*100)+1;
	System.out.println("猜一个数字");
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	int flag=1;
	do {
			if(num>number) {
			System.out.println("大了,重新输入");
		}else {
			System.out.println("小了，重新输入");
		}
			flag++;
			if(flag>3) {
			System.out.println("输入次数过多，游戏结束");
			return;
			}
			num=sc.nextInt();
			}while(num==number);
	sc.close();
	System.out.println(num);
	System.out.println(flag);
}
}
