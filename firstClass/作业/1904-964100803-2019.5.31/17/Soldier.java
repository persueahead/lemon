package homework;

public class Soldier extends NamedRole {
  private int hurt;   //ͽ���˺�
  private Weapon weapon;  //������˽�е�Ҫͨ��setget��������
  public void setWeapon(Weapon weapon) {
	  this.weapon=weapon;
  }
  public Weapon getWeapon() {
	  return weapon;
  }
  public Soldier(String name,int age,  int hurt) { //��ʼ��սʿ
		super(name, age); //
		this.hurt = hurt;
	}

@Override
public int attack() {
	// TODO Auto-generated method stub
	int result=hurt;
	if(weapon.fire()!=0) {
		return result=hurt+weapon.fire(); //�������Լӳ�
	}else {
		return result;
	}
}
@Override
public void practices() {
	// TODO Auto-generated method stub
	hurt+=10;
}
  
	  
  }
class Bolo implements Weapon{ //��
	private Soldier  s;
		@Override
	public void setSoldier(Soldier s) { //����ʹ����
		// TODO Auto-generated method stub
		this.s=s;
	}

	@Override
	public int fire() {
		// TODO Auto-generated method stub
		if(s.getAge()>=18) {
			return 100;
		}else {
			return 50;
		}
	}
}
class Pike implements Weapon{ //��ì
	private String name;
	private Soldier s;
	public Pike(String name) { //����ʹ��������
		this.name=name;
	}
			@Override
	public void setSoldier(Soldier s) {
		// TODO Auto-generated method stub
		this.s=s;
	}

	@Override
	public int fire() {
		// TODO Auto-generated method stub
		if(s.getName().equals(name)) {
			return 1000;
		}else {
			return 25;
		}
	}
	
}
	

