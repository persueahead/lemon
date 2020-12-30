package homework;

public class Controller {
	private MediaPlayer[] players;
	public Controller(){
	//���캯���г�ʼ�� players ����
		players=new MediaPlayer[3];
		players[0]=new DVDPlayer();
		players[1]=new CDPlayer();
		players[2]=new TapePlayer();
	}
	//����Ӧ���豸���� play ����
	public void play(int i){
	players[i].play();
	}
	public void stop(int i) {
		players[i].stop();
	}
	public void open(int i) {
		players[i].open();
	}
	public static void main(String[] args) {
		Controller c=new Controller();
		c.play(1);
	}
}
