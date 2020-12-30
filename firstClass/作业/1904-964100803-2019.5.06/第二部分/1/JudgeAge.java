package day5_06;

import java.util.Scanner;

public class JudgeAge {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入年龄");
			int age=sc.nextInt();
			if(age>50) {
				System.out.println("中老年");
			}else if(18<age&age<35) {
				System.out.println("青年");
			}else if(14<age&&age<17) {
				System.out.println("青少年");
			}else if(age>6&&age<13) {
				System.out.println("少儿");
			}else if(age>=0&&age<6){
				System.out.println("儿童");
			}else {
				System.out.println("年龄输入有误");
			}
	    sc.close();
	}

}
