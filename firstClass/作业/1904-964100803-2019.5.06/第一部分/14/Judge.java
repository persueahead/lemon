package day5_06;

import java.util.Scanner;

public class Judge {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("�������0��һ����λ��");
	  int num=sc.nextInt();
	  int sum=num%10+num/10%10+num/100%10+num/1000;
	  System.out.println(sum);
	  if(num%2==0) {
		  System.out.println("��λ����ż��");
	  }else {
		  System.out.println("��λ��������");
	  }
	  sc.close();
  }
}
