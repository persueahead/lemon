package homework;

public class Soldier extends NamedRole {
  private int hurt;   //徒手伤害
  private Weapon weapon;  //武器，私有的要通过setget方法访问
  public void setWeapon(Weapon weapon) {
	  this.weapon=weapon;
  }
  public Weapon getWeapon() {
	  return weapon;
  }
  public Soldier(String name,int age,  int hurt) { //初始化战士
		super(name, age); //
		this.hurt = hurt;
	}

@Override
public int attack() {
	// TODO Auto-generated method stub
	int result=hurt;
	if(weapon.fire()!=0) {
		return result=hurt+weapon.fire(); //加上属性加成
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
class Bolo implements Weapon{ //大刀
	private Soldier  s;
		@Override
	public void setSoldier(Soldier s) { //设置使用者
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
class Pike implements Weapon{ //长矛
	private String name;
	private Soldier s;
	public Pike(String name) { //限制使用者名字
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
	

