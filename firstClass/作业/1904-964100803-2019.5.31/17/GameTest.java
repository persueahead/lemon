package homework;

public class GameTest {
public static void main(String[] args) {
	/*MagicStick a=new GreenStick();//绿杖
	MagicStick b=new BlackStick();//黑杖
	Magicer m1 = new Magicer("黑魔导",40);//定义法师1
	Magicer m2 = new Magicer("瑞兹",80);//定义法师2
	m1.setLevel(156);//设置等级
	m2.setLevel(90);
	System.out.println("m1等级:"+m1.getLevel());//打印等级
	System.out.println("m2等级:"+m2.getLevel());
	m1.setStick(a);  //有绿杖
	m2.setStick(null); //无法杖加成
	System.out.println("m1攻击力"+m1.attack());//显示攻击力
	System.out.println("m2攻击力"+m2.attack());
	GreenStick.month=4;//设置月份进而反馈法杖属性加成fire();
	m1.practices();//练习升级
	m2.practices();
	System.out.println("m1等级:"+m1.getLevel());//打印等级
	System.out.println("m2等级:"+m2.getLevel());
	System.out.println("-------------------------");*/
	Weapon w1=new Bolo();
	Weapon w2=new Pike("狼人");//限定使用者名称
	Soldier s1 = new Soldier("皇子", 30, 300);
	Soldier s2 = new Soldier("狼人", 20, 270);
	w1.setSoldier(s1);//传入使用者
	w2.setSoldier(s2);
	s1.setWeapon(w1);//传入武器
	s2.setWeapon(w2);
	System.out.println(s1.attack());
	System.out.println(s2.attack());
	s1.practices();
	s2.practices();
	System.out.println(s1.attack());
	System.out.println(s2.attack());
	
	
}
}
