
public class Person {
   String name;
   String id;
    int age;
    public void compare(Person a,Person b) {
    	if(a.age>b.age) {
    		System.out.println(a.name+"�����");
    	}else {
    		System.out.println(b.name+"�����");
    	}
    }
    public Person(String name,String id,int age) {
    	this.name=name;
    	this.id=id;
    	this.age=age;
    }
    public static void main(String[] args) {
		Person a=new Person("����","0101",22);
		Person b=new Person("����","0102",19);
		a.compare(a,b);
		
	}
}
