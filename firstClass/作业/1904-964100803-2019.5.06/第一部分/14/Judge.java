package day5_06;

import java.util.Scanner;

public class Judge {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("输入大于0的一个四位数");
	  int num=sc.nextInt();
	  int sum=num%10+num/10%10+num/100%10+num/1000;
	  System.out.println(sum);
	  if(num%2==0) {
		  System.out.println("各位和是偶数");
	  }else {
		  System.out.println("各位和是奇数");
	  }
	  sc.close();
  }
}
