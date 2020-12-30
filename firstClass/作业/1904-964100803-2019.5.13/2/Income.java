package zixue01;

import java.util.Scanner;

public class Income {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  int arr[]=null,sum=0;
	  arr=new int[12];
	  System.out.println("依次输入12个月的收入(k)");
	  for(int i=0;i<12;i++) {
		  arr[i]=sc.nextInt();
		  	  }
	  sc.close();
	   for(int i=0;i<12;i++) {
		   sum+=arr[i];
	   }
	  System.out.println("一年总收入："+sum+"k");
}
}
