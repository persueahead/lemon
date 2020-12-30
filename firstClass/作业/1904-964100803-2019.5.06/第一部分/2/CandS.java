package day5_06;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CandS {
  public static void main(String args[]) {
	  double r,c,s;
	  System.out.println("输入所求圆的半径r");
	  Scanner sc=new Scanner(System.in);
	  r=sc.nextDouble();
	  c= 2*Math.PI*r;
	  s= Math.PI*r*r;
	  //设置double类小数点位数
	  DecimalFormat df = new DecimalFormat( "0.00");
	  System.out.println("此圆周长"+df.format(c));
	  System.out.println("此圆面积"+df.format(s));
	  sc.close();
  }
}
