package xuanzeti;
import java.text.DecimalFormat;

public class Test2 {
public static void main(String[] args) {
	Shape shape[]=new Shape[3];
	shape[0]=new Cicle();
	shape[1]=new Rect();
	shape[2]=new Square();
	for(int i=0;i<3;i++) {
		double a=shape[i].area();
		double b=shape[i].girth();
		DecimalFormat df = new DecimalFormat("0.00");
	    System.out.println(shape[i].getName()+"面积:"+df.format(a));
	    System.out.println(shape[i].getName()+"周长:"+df.format(b));
	}
}
}
