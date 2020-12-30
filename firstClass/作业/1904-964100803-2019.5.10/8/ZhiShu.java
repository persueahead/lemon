package zixue01;

public class ZhiShu {
public static void main(String[] args) {
	 int flag=0;
	 for(int a=1;a<=1000;a++) {
     boolean c=true;
     
	 for(int b=2;b<=Math.sqrt(a);b++) {
		if(a%b==0)
			c=false;
	 		}
	if(c) {
		System.out.println(a);
		flag++;
				}
		}
	System.out.println("×Ü¹²"+flag+"¸ö");
	}
}
