package day7;

import java.util.Scanner;

public class Grade {
	public static void main(String[] args) {
		int arr[]=null;
		arr=new int[5];
		int sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("�����������ѧ���ĳɼ�");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		int max=0,min=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
				sum+=arr[i];
				}
		for(int y=0;y<arr.length;y++) {
				if(arr[y]<arr[0]) {
				arr[0]=arr[y];
			}
		}
		min=arr[0];
					}
		sc.close();
		System.out.println("��߷֣�"+max+"\n��ͷ֣�"+min);
		System.out.println("ƽ���֣�"+(sum/5.0));
	 
   }
}