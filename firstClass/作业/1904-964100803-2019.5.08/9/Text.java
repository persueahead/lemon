package day_06;

public class Text {
	public static void main(String[] args) {
		int flag=0;
	for(int i=1;i<101;i++) {
		if(i%3==0) {
			flag++;
			if(flag<6)
				System.out.println(i);
			}
		}
	}
}
