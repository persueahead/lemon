
public class Person {
   String name;
   String id;
    int age;
    public void compare(Person a,Person b) {
    	if(a.age>b.age) {
    		System.out.println(a.name+"年龄大");
    	}else {
    		System.out.println(b.name+"年龄大");
    	}
    }
    public Person(String name,String id,int age) {
    	this.name=name;
    	this.id=id;
    	this.age=age;
    }
    public static void main(String[] args) {
		Person a=new Person("张三","0101",22);
		Person b=new Person("李四","0102",19);
		a.compare(a,b);
		
	}
}
