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
		System.out.println("进行DVD播放");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("停止DVD播放");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("DVD开仓");
	}
	
}
class CDPlayer implements MediaPlayer{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("播放CD");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("暂停CD播放机");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("CD机开仓");
	}
	
}
class TapePlayer implements MediaPlayer{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("播放磁带");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("暂停播放磁带");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("录音机准备");
	}
	
}