package homework;

import java.util.Scanner;

 class Test1 implements Judge {
	@Override
	public boolean test(int n) {
		// TODO Auto-generated method stub
		for(int i=2;i<Math.sqrt(n);i++) {
			if(n%i==0) {
			return false;}
			}
		return true;			
		}
	
}
public class Test{
	public static void main(String[] args) {
	Judge s=new Test1();
	System.out.println("����һ������6��ż��");
	Scanner sc=new Scanner(System.in);
	int a=sc.nextInt();
	for(int i=2;i<a/2;i++) {
		if(s.test(i)&&s.test(a-i)) {
		System.out.println(a+"="+i+"+"+(a-i));
			}else {
				continue;
			}
		}
	
  }
}
interface Judge{
	boolean test(int n);
}
