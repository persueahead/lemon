package homework;

public interface MediaPlayer {
void play();
void stop();
void open();
}
class DVDPlayer implements  MediaPlayer{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("����DVD����");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("ֹͣDVD����");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("DVD����");
	}
	
}
class CDPlayer implements MediaPlayer{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("����CD");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("��ͣCD���Ż�");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("CD������");
	}
	
}
class TapePlayer implements MediaPlayer{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("���ŴŴ�");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("��ͣ���ŴŴ�");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("¼����׼��");
	}
	
}