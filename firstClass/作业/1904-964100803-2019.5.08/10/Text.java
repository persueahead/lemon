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
					System.out.println("������"+flag);
					System.out.println("����ֻ����"+a);
					System.out.println("ĸ��ֻ����"+b);
					System.out.println("С��ֻ����"+c);
					
					}
			   }
			}
		}
	}
}
