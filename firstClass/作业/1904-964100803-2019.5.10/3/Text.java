package zixue01;

import java.util.Scanner;

public class Text {
public static void main(String[] args) {
		int a=5,b=6;
		System.out.println("���="+add(a,b));
		judge(a,b);
		System.out.println("��ȡ��������������"+max(a,b));
		Scanner sc=new Scanner(System.in);
		System.out.println("��ӡc�У�d�����ξ��Σ��붨������");
		int c=sc.nextInt();
		int d=sc.nextInt();
		Text t=new Text();
		t.picture(c,d);
		System.out.println("��ӡnn�˷���,�붨��n");
		int n=sc.nextInt();
		t.excle(n);
		System.out.println("����������������ȡ���ֵ");
		int e=sc.nextInt();
		int f=sc.nextInt();
		int g=sc.nextInt();
		System.out.println("�������"+max2(e,f,g));
		sc.close();
		
}

public static int  add(int a,int b) {
	return a+b;
 }
public  static void judge(int a,int b) {
	if(a==b)
		System.out.println("���");
	else
		System.out.println("�����");
}
public static int  max(int a,int b) {
	return a>b?a:b;
}
public  void picture(int x,int y) {
	for(int a=1;a<=x;a++) {
		for(int b=1;b<=y;b++) {
			if(a==1||a==x||b==1||b==y){
				System.out.print("*");
			}else {
				System.out.print(" ");
			}
		}
		System.out.println(" ");
	}
 }
public  void excle(int n) {
	for(int x=1;x<=n;x++) {
		for(int y=1;y<=x;y++) {
			System.out.print(y+"*"+x+"="+(x*y)+" ");
		}
		System.out.println(" ");
	}
		
	}
public static int max2(int a,int b,int c) {
	int max=a>b?a:b;
	max=max>c?max:c;
	return max;
}
	
 }


