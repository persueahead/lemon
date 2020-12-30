package day_06;

public class Add {
public static void main(String[] args) {
		int sum1=0,sum2=0,sum3=0,factorical=1;
		for(int i=0;i<101;i++) {
			sum1+=i;
		}
		System.out.println("1-100求和："+sum1);
		for(int y=1;y<101;y++) {
			if(y%2==0) {
				sum2+=y;
			}
		}
		System.out.println("1-100偶数求和："+sum2);
		for(int z=1;z<101;z++) {
			if(z%2!=0) {
				sum3+=z;
			}
		}
		System.out.println("1-100奇数求和："+sum3);
		for(int m=100;m<1000;m++) {
			int g=m%10;
			int s=m/10%10;
			int b=m/100;
			if(Math.pow(g, 3)+Math.pow(s, 3)+Math.pow(b, 3)==m) {
				System.out.println("三位水仙花数:"+m);
			}
		}
		for (int k=5;k>0;k--) {
				factorical*=k;
		}
		System.out.println("5的阶乘："+factorical);
	}
}
