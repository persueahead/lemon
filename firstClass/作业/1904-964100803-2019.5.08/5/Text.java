package day_06;

public class Text {
	public static void main(String[] args) {
		int flag=0;
	for(int i=1;i<1001;i++) {
		if(i%3==2&&i%5==3||i%7==2)
			flag++;
			}
	System.out.println(flag);
}
}
