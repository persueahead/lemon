package day5_06;

import java.util.Scanner;

public class Mark {
  public static void main(String[] args) {
	  	Scanner sc=new Scanner(System.in);
	  	System.out.println("输入成绩");
	  	int mark=sc.nextInt();
	    switch(mark/10) {
	    case 10:
	    case 9:
	    	System.out.println("成绩优秀");
	        break;
	    case 8:
	    	System.out.println("成绩良好");
	        break;
	    case 7:
	    	System.out.println("成绩一般");
	    	break;
	    case 6:
	    	System.out.println("成绩及格");
	    	break;
	    default:
	    	System.out.println("成绩不及格");
	    }
	    sc.close();
  }
}
