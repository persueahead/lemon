package homework;

public class GameTest {
public static void main(String[] args) {
	/*MagicStick a=new GreenStick();//����
	MagicStick b=new BlackStick();//����
	Magicer m1 = new Magicer("��ħ��",40);//���巨ʦ1
	Magicer m2 = new Magicer("����",80);//���巨ʦ2
	m1.setLevel(156);//���õȼ�
	m2.setLevel(90);
	System.out.println("m1�ȼ�:"+m1.getLevel());//��ӡ�ȼ�
	System.out.println("m2�ȼ�:"+m2.getLevel());
	m1.setStick(a);  //������
	m2.setStick(null); //�޷��ȼӳ�
	System.out.println("m1������"+m1.attack());//��ʾ������
	System.out.println("m2������"+m2.attack());
	GreenStick.month=4;//�����·ݽ��������������Լӳ�fire();
	m1.practices();//��ϰ����
	m2.practices();
	System.out.println("m1�ȼ�:"+m1.getLevel());//��ӡ�ȼ�
	System.out.println("m2�ȼ�:"+m2.getLevel());
	System.out.println("-------------------------");*/
	Weapon w1=new Bolo();
	Weapon w2=new Pike("����");//�޶�ʹ��������
	Soldier s1 = new Soldier("����", 30, 300);
	Soldier s2 = new Soldier("����", 20, 270);
	w1.setSoldier(s1);//����ʹ����
	w2.setSoldier(s2);
	s1.setWeapon(w1);//��������
	s2.setWeapon(w2);
	System.out.println(s1.attack());
	System.out.println(s2.attack());
	s1.practices();
	s2.practices();
	System.out.println(s1.attack());
	System.out.println(s2.attack());
	
	
}
}
