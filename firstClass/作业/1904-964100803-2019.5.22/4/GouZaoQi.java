
public class GouZaoQi {
public static void main(String[] args) {
	 Rectangle a=new Rectangle(12,6);
	 a.JuXingC(a.height, a.weight);
	 a.JuXingS(a.height,a.weight);
	 
}
}
class Rectangle {
	int height;
	int weight;
	public Rectangle(int height,int weight) {
		this.height=height;
		this.weight=weight;
	}
	public void JuXingC(int a,int b) {
		int C=2*(a+b);
		System.out.println("�����ܳ���"+C);
	}
	public void JuXingS(int a,int b) {
		int S=a*b;
		System.out.println("���������"+S);
	}
}