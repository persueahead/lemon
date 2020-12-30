package com;

import java.util.Arrays;

public class Ergodic {
	public static void main(String[] args) {
		int[][] arr= {{12,11,9},{67,12},{33,35,39,40}};
		System.out.println(Arrays.deepToString(arr)); 
		int sum=0;
		for(int i=0;i<arr.length;i++) {
		 sum+=arr[i].length;
		}
		System.out.println("ÔªËØ¸öÊý£º"+sum);
		}
	}

