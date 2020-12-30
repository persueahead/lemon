package com;

import java.util.Arrays;

public class Ergodic {
	public static void main(String[] args) {
		int[][] arr= {{12,11,9},{67,12},{33,35,39,40}};
		System.out.println(Arrays.deepToString(arr)); 
		int sum1=0;
		int sum2=0;
		for(int i=0;i<arr.length;i++) {
		 sum1+=arr[i].length;
		 for(int j=0;j<arr[i].length;j++) {
			 sum2+=arr[i][j];
		 }
		}		
		System.out.println("元素个数："+sum1);
		System.out.println("元素和："+sum2);
		}
	}

