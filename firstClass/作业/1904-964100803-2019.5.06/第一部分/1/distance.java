package day5_06;
import java.util.Scanner;

public class distance {
		public static void main(String args[]) {
			double x1,x2,y1,y2,distance;
			Scanner sc=new Scanner(System.in);
			System.out.println("ÊäÈë×ø±êx1,y1ºÍx2,y2");
			x1=sc.nextDouble();
			y1=sc.nextDouble();
			x2=sc.nextDouble();
			y2=sc.nextDouble();
			distance=Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
			System.out.println(distance);
			sc.close();
		}
	}
