package homework;

public class Test{
	public static void main(String[] args) {
		Cicle c=new Cicle();
		c.getShape(0).getArea();
		c.getShape(0).getPerimeter();
	}
		
}

class Cicle implements Shape{
	double perimeter;
	double area;
	public Cicle() {}
	public Cicle(int i) {
		this.r=i;
		System.out.println("�뾶Ϊ"+r+"��Բ");
	}
	float r;
	
	public void getArea() {
		 area=Math.PI*Math.pow(r,2);
		System.out.println("Բ�����"+area);
	 }
			
		public Shape getShape(int i) {
		if(i==0) {
			return new Cicle(1);
		}else {
			return null;
		}
	}
	public void getPerimeter(){
		 perimeter=2*Math.PI*r;
		 System.out.println("Բ�ܳ���"+perimeter);
	}
	
	
}
class Square implements Shape{
	float side;
	double area;
	double perimeter;
	public Square() {}
	public Square(float i) {
		side=i;
	}
	
	public void getArea() {
		area=side*side;
		System.out.println("�����������"+area);
	 }
	 
	public void getPerimeter(){
		 perimeter=4*side;
	 System.out.println("�������ܳ���"+perimeter);
	 }

	public Shape getShape(int i) {
		if(i==1) {
			 return new Square(2);
	}else {
		return null;
	}
	
 }
}
class JuXing implements Shape{
	float length;
	float wide;
	double area;
	double perimeter;
	public JuXing() {}
	public JuXing(float a,float b){
		length=a;
		wide=b;
	}
	
	public void getArea() {
		area=length*wide;
		System.out.println("�������:"+area);
		}
	public Shape getShape(int i) {
		if(i==2) {
			 return new JuXing(3,2);
	}else {
		return null;
	}
}
	public void getPerimeter(){
		 perimeter=2*(length+wide);
		 System.out.println("�����ܳ���"+perimeter);
	 }
	
}


