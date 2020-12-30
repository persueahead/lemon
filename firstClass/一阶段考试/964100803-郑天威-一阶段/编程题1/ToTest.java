package xuanzeti;

public class ToTest {
	public static void main(String[] args) {
	Student stu[]=new Student[3];
	stu[0]=new Student("张三",22);
	stu[1]=new Student("李四",21);
	stu[2]=new Student("王五",20);
	for(int i=0;i<3;i++) {
		stu[i].run();
	}
}

}
