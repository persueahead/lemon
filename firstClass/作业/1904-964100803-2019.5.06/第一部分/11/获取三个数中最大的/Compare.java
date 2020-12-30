package day5_06;

public class Compare {
  public static void main(String[] args) {
	int a=1,b=2,c=3;
	int temp = a > b? a: b;
	int max = temp > c? temp: c;
	System.out.println(max);
}
}
