package day5_06;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CandS {
  public static void main(String args[]) {
	  double r,c,s;
	  System.out.println("��������Բ�İ뾶r");
	  Scanner sc=new Scanner(System.in);
	  r=sc.nextDouble();
	  c= 2*Math.PI*r;
	  s= Math.PI*r*r;
	  //����double��С����λ��
	  DecimalFormat df = new DecimalFormat( "0.00");
	  System.out.println("��Բ�ܳ�"+df.format(c));
	  System.out.println("��Բ���"+df.format(s));
	  sc.close();
  }
}
