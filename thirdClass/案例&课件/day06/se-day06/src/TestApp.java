
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Deprecated
public class TestApp {

	
	private  String name;
	
   public static void main(String[] args) throws Exception {
	new TestApp().testname();
}
	@Deprecated
	public void testName01() throws Exception {
		
	}



	public void testname() throws Exception {
		//class c= XXX class;
		Annotation[]  ann= this.getClass().getAnnotations();
		for (Annotation annotation : ann) {
			System.out.println(annotation.getClass().getName());
		}
		
		
		/*
		 * Method[] app= this.getClass().getDeclaredMethods(); for (Method method : app)
		 * { System.out.println(method.getName()); String str= method.getName();
		 * System.out.println(method.isAnnotationPresent(Deprecated.class));
		 * if(method.isAnnotationPresent(Deprecated.class)) {
		 * System.out.println("----XUXUX---------");
		 * 
		 * } }
		 */
		
		
		
	}
	
	
	
}
