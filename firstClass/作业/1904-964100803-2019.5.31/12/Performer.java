package homework;

	public interface Performer {
	void perform();
}

class Singer implements Performer{

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("歌手上台唱歌");
	}
	
}
class Dancer implements Performer{

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("舞蹈员上台起舞");
	}
	
}
class Player implements Performer{

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("乐器演奏者开始演奏");
	}
	
}
