package day5_06;

import java.util.Scanner;

public class BodyType {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("20�������ͼ��");
		System.out.println("�������أ��");
		float weight=sc.nextFloat();
			if(weight>140) {
				System.out.println("ƫ��");
			}else if(weight>120) {
				System.out.println("ǿ׳");
			}else if(weight>100) {
				System.out.println("����");
			}else if(weight>80) {
				System.out.println("ƫ��");
			}else {
				System.out.println("������");
			}
	    sc.close();
	}

}
