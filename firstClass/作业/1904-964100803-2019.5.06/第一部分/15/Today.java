package day5_06;

public class Today {
  public static void main(String[] args) {
	 String week[]= {"sanday","monday","tuesday","wednesday","thursday","friday","saturday"};
	 String today=week[5];
	 System.out.println("������"+today);
	 today=week[(5+20)%7];
	 System.out.println("20���"+today);
  }
}
