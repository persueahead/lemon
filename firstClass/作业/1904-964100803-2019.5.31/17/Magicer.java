package homework;


public class Magicer extends NamedRole {
	private MagicStick stick;//法杖
    private  int level;//等级
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
	public int attack() {  //显示攻击值
		// TODO Auto-generated method stub
		return 5*level;
	}

	public MagicStick getStick() {
		return stick;
	}
	public void setStick(MagicStick stick) {//设置权杖对象
		this.stick = stick;
	}
	@Override
	public void practices() {  //设置练习场
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
	public int fire() { //法杖属性
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