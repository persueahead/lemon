package homework;


public class Magicer extends NamedRole {
	private MagicStick stick;//����
    private  int level;//�ȼ�
    public Magicer(String name,int age) {
    	super(name,age);
    }
	public int getLevel() {
		return level;
	}
	public  void setLevel(int level) {
		this.level = level;
	}
	@Override
	public int attack() {  //��ʾ����ֵ
		// TODO Auto-generated method stub
		return 5*level;
	}

	public MagicStick getStick() {
		return stick;
	}
	public void setStick(MagicStick stick) {//����Ȩ�ȶ���
		this.stick = stick;
	}
	@Override
	public void practices() {  //������ϰ��
		// TODO Auto-generated method stub
		if(stick==null) {
			level++;
		}else {
			level+=1+stick.fire();
		}
	}
}
class GreenStick implements MagicStick{
	 static int month; 
	@Override
	public int fire() { //��������
		// TODO Auto-generated method stub
		if(month>5&&month<9) {
			return 1;
		}else {
			return 2;
		}
	}
	
}
class BlackStick implements MagicStick{

	@Override
	public int fire() {
		// TODO Auto-generated method stub
		if(GreenStick.month%2!=0) {
			return 1;
		}else {
			return 2;
		}
	}
	
}