package day5_06;

import java.util.Scanner;

public class BodyType {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("20周岁体型检测");
		System.out.println("输入体重（斤）");
		float weight=sc.nextFloat();
			if(weight>140) {
				System.out.println("偏胖");
			}else if(weight>120) {
				System.out.println("强壮");
			}else if(weight>100) {
				System.out.println("正常");
			}else if(weight>80) {
				System.out.println("偏瘦");
			}else {
				System.out.println("不正常");
			}
	    sc.close();
	}

}
