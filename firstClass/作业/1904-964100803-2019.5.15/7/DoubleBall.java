package day7;

import java.util.Arrays;
import java.util.Scanner;

public class DoubleBall {
		public static void main(String[] args) {
		int red[]=new int[6];
		int blue[]=new int[1];
		int guess1[]=new int[6];
		int guess2[]=new int[1];  
		System.out.println("游戏开始");
		start1(red);
		start2(blue);
		people(guess1,guess2);
		compare(red,blue,guess1,guess2);
		System.out.println("档期红球："+Arrays.toString(red));
		System.out.println("档期蓝球："+Arrays.toString(blue));
	}
	public static void start1(int[] a) {
		for(int i=0;i<6;i++) {
			a[i]=random1();
		}
		
	}
	public static void start2(int[] b) {
		 b[0]= random2();
			}
	public static int random1() {
		int a=0;
		a=(int) (Math.random()*33+1);
			return a;
	}
	public static int random2() {
		int a=0;
		a=(int) (Math.random()*16+1);
		return a;
	}
	public static void people(int[] a,int[] b) {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入六个红球");
		for(int i=0;i<6;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("所彩红球："+Arrays.toString(a));
		System.out.println("输入一个蓝球");
		b[0]=sc.nextInt();
		System.out.println("所猜蓝球："+Arrays.toString(b));
	}
	public static void compare(int[] a,int[] b,int[] c,int[] d) {
		Arrays.sort(a);
		Arrays.sort(c);
		int count1=0;
		int count2=0;
			for(int i=0;i<6;i++) {
			if(a[i]==c[i]) {
				count1++;
			}
		}
			if(b[0]==d[0]) {
				count2=1;
			}else {
				count2=0;
			}
		if(count1==6&&count2==1) {
			System.out.println("一等奖");
		}else if(count1==6&&count2==0) {
			System.out.println("二等奖");
		}else if(count1==5&&count2==0) {
			System.out.println("三等奖");
		}else if(count1==5||(count1==4&&count2==1)) {
			System.out.println("四等奖");
		}else if(count1==4||(count1==3&&count2==1)){
			System.out.println("五等奖");
		}else if(count1==0&&count2==1){
			System.out.println("六等奖");
		}else {
			System.out.println("未中奖");
		}
	}
}
