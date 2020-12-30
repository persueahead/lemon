package com;

import java.util.Arrays;

public class Delect {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9};
		System.out.println("原数组："+Arrays.toString(arr));
		int[] arr1=null;
		arr1=new int[arr.length-4];
		System.arraycopy(arr, 0, arr1, 0, 3);
		System.arraycopy(arr, 7, arr1, 3, arr.length-7);
		System.out.println("新数组："+Arrays.toString(arr1));
	}
}
