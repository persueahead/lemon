package xuanzeti;

public class Student implements Person {
private  String name;
private int age;
public Student(String name,int age) {
	this.name=name;
	this.age=age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public void speak() {
	// TODO Auto-generated method stub
	System.out.println(this.name+"��˵��");
}
@Override
public void run() {
	// TODO Auto-generated method stub
	System.out.println("�ҽ�"+this.name+",����"+this.age);
	
}

}
