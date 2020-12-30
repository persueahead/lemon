package xuanzeti;

public class Shape {
public double area() {
	return 0;
	
}
public double girth() {
	return 0;	
 }
public String getName() {
	return null;
}
}
class Cicle extends Shape{ 
	private String name="圆";
	public String getName() {
		return this.name;
	}
	private double r=3.0;
	public double area() {
		// TODO Auto-generated method stub
		return (Math.PI*r*r);
	}

	public double girth() {
		// TODO Auto-generated method stub
		return (2*Math.PI*r);
	}
	
}
class Rect extends Shape{
	private String name="矩形";
	public String getName() {
		return this.name;
	}
	private  double length=1.5;
	private double width=1;
	public double area() {
		// TODO Auto-generated method stub
		return   2*(length+width);
	}	
	public double girth() {
		// TODO Auto-generated method stub
		return (width*length);
	}
}
class Square extends Rect{
	private String name="正方形";
	public String getName() {
		return this.name;
	}
	private double side=2.4;
	public double area() {
		// TODO Auto-generated method stub
		return (side*side);
	}
	public double girth() {
		// TODO Auto-generated method stub
		return (4*side);
	}
	
}
