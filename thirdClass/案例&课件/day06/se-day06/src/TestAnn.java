import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAnn {

	
	public static void main(String[] args) {
		System.out.println("----------------");
	}
	/*
	 * public static void main(String[] args) {
	 * System.out.println("----------------"); }
	 */
	
	/**
	 * 标识在测试类(标识了@Test的这个类)之前进行执行
	 * @throws Exception
	 */
	@Before
	public void testname() throws Exception {
		 System.out.println("======@Before===========");
	}
	/**
	 * 在测试类之后进行执行的方法
	 * @throws Exception
	 */
	@After
	public void testname01() throws Exception {
		System.out.println("==========@After==========");
	}
	/**
	 * 用于测试的
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception {
		  System.out.println("我进行测试了数据test01");
	}
	@Test
	public void test02() throws Exception {
		  System.out.println("我进行测试了数据test02");
	}
}
