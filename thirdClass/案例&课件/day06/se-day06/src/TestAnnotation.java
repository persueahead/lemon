import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;


public class TestAnnotation extends Person {
//	@MySuper(key = { "xxxxx" }, name = "ooooo")
	public  String name;
	
	@Override
	public void testname() throws Exception {
		// TODO Auto-generated method stub
		super.testname();
	}

	
	
	
	
	
	@SuppressWarnings("rawtypes")
	ArrayList  array=new  ArrayList();
	

}





/*
 * @MySuper(key = { "xxxxx" }, name = "ooooo")
 */


class  Person{
	@Deprecated
	public void testname() throws Exception {
	}
}