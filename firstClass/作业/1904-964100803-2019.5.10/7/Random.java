package zixue01;

public class Random {
public static void main(String[] args) {
	int a=random();
	System.out.println(a);
}
public static int random() {
	return (int)(Math.random()*100+1);
}

}
