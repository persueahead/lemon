package day7;

import java.util.Scanner;

public class Sudoku {
	public static void main(String[] args) {
		int[][] arr=new int[3][3];
		System.out.println("Ϊ��ά��������Ÿ�1~9���ڵ���");
		Get(arr);
		if(test(arr)) {
			System.out.println("�ǾŹ���");
		}else {
			System.out.println("����");
		}
		
		
	}
	public static void Get(int[][] arr) {
			Scanner sc=new Scanner(System.in);
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					arr[i][j]=sc.nextInt();
				}
		}
	}
	public static boolean test(int[][] arr) {
		boolean flag=true;
		int sum1=0;
		int sum2=0;
		int sum3=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
			sum1+=arr[i][j];
			 sum2+=arr[j][i];
			
			}
			 System.out.println("sum1:"+sum1);
			 System.out.println("sum2:"+sum2);
			if(sum1!=15||sum2!=15) {
				flag=false;
			}
			sum1=0;
			sum2=0;
		}
							  		
			for(int k=0;k<3;k++) {
				sum3+=arr[k][k];
				}
			if(sum3!=15) {
				flag=false;
			}
			if(arr[0][2]+arr[1][1]+arr[2][0]!=15) {
				flag=false;
			}
			return flag;
		}
	}

