package homework;

	public interface Performer {
	void perform();
}

class Singer implements Performer{

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("������̨����");
	}
	
}
class Dancer implements Performer{

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("�赸Ա��̨����");
	}
	
}
class Player implements Performer{

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("���������߿�ʼ����");
	}
	
}
