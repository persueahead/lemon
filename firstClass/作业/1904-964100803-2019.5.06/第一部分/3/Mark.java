package day5_06;

import java.util.Scanner;

public class Mark {
  public static void main(String[] args) {
	  	Scanner sc=new Scanner(System.in);
	  	System.out.println("����ɼ�");
	  	int mark=sc.nextInt();
	    switch(mark/10) {
	    case 10:
	    case 9:
	    	System.out.println("�ɼ�����");
	        break;
	    case 8:
	    	System.out.println("�ɼ�����");
	        break;
	    case 7:
	    	System.out.println("�ɼ�һ��");
	    	break;
	    case 6:
	    	System.out.println("�ɼ�����");
	    	break;
	    default:
	    	System.out.println("�ɼ�������");
	    }
	    sc.close();
  }
}
