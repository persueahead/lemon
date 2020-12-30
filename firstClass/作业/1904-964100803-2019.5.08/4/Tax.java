package day_06;

import java.util.Scanner;

public class Tax {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("输入税前所得");
	float money=sc.nextInt();
	if(money<2000) {
		System.out.println("不征税");
		return;
		}
	float z=(money-2000);//应税所得
	float tag=0;//应交税
	float own=0;//最后所得
	if(z>0&&z<=500) {
		tag=z*0.05f;
		own=money-tag;
	}else if(z>500&&z<=2000) {
		tag=(z-500)*0.1f+500*0.05f;
		own=money-tag;
	}else if(z>2000&z<=5000) {
		tag=(z-2000)*0.15f+1500*0.1f+500*0.05f;
		own=money-tag;
	}else if(z>5000&&z<20000) {
		tag=(z-5000)*0.2f+3000*.015f+1500*0.1f+500*0.05f;
		own=money-tag;
	}else if(z>20000&&z<=40000) {
		tag=(z-20000)*0.25f+15000*0.2f+3000*0.15f+1500*0.1f+500*0.05f;
		own=money-tag;
	}else if(z>40000&&z<=60000) {
		tag=(z-40000)*0.3f+20000*0.25f+15000*0.2f+3000*0.15f+1500*0.1f+500*0.05f;
		own=money-tag;
	}else if(z>60000&&z<=80000) {
		tag=(z-60000)*0.35f+20000*0.3f+20000*0.25f+15000*0.2f+3000*0.15f+1500*0.1f+500*0.05f;
		own=money-tag;
	}else if(z>80000&&z<100000) {
		tag=(z-80000)*0.4f+20000*0.35f+20000*0.3f+20000*0.25f+15000*0.2f+3000*0.15f+1500*0.1f+500*0.05f;
		own=money-tag;
	}else if(z>100000) {
		tag=(z-100000)*0.45f+20000*0.4f+20000*0.35f+20000*0.3f+20000*0.25f+15000*0.2f+3000*0.15f+1500*0.1f+500*0.05f;
		own=money-tag;
	}
	System.out.println("应交税："+tag);
	System.out.println("税后所得："+own);
}
}
