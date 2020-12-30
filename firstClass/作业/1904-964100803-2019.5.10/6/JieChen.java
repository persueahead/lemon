package zixue01;

import java.util.Scanner;

public class JieChen {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("求一个数的阶乘，请输入");	
	int a=sc.nextInt();
	System.out.println(factorial(a));
}
public static int factorial(int a) {
	if(a==1) 
		return 1;
	return a*factorial(a-1);
	
}
}
