package day_06;

public class Text {
	public static void main(String[] args) {
			int a ,b,c,flag;
				flag=0;
		for(a=1;a<20;a++) {
			for(b=1;b<33;b++) {
				for(c=1;c<99;c++)
			if(a*5+3*b+c/3==100) {
				if(a+b+c==100) {
					flag++;
					System.out.println("方案："+flag);
					System.out.println("公鸡只数："+a);
					System.out.println("母鸡只数："+b);
					System.out.println("小鸡只数："+c);
					
					}
			   }
			}
		}
	}
}
