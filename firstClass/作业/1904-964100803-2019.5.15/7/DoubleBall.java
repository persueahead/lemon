package day7;

import java.util.Arrays;
import java.util.Scanner;

public class DoubleBall {
		public static void main(String[] args) {
		int red[]=new int[6];
		int blue[]=new int[1];
		int guess1[]=new int[6];
		int guess2[]=new int[1];  
		System.out.println("��Ϸ��ʼ");
		start1(red);
		start2(blue);
		people(guess1,guess2);
		compare(red,blue,guess1,guess2);
		System.out.println("���ں���"+Arrays.toString(red));
		System.out.println("��������"+Arrays.toString(blue));
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
		System.out.println("������������");
		for(int i=0;i<6;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("���ʺ���"+Arrays.toString(a));
		System.out.println("����һ������");
		b[0]=sc.nextInt();
		System.out.println("��������"+Arrays.toString(b));
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
			System.out.println("һ�Ƚ�");
		}else if(count1==6&&count2==0) {
			System.out.println("���Ƚ�");
		}else if(count1==5&&count2==0) {
			System.out.println("���Ƚ�");
		}else if(count1==5||(count1==4&&count2==1)) {
			System.out.println("�ĵȽ�");
		}else if(count1==4||(count1==3&&count2==1)){
			System.out.println("��Ƚ�");
		}else if(count1==0&&count2==1){
			System.out.println("���Ƚ�");
		}else {
			System.out.println("δ�н�");
		}
	}
}
