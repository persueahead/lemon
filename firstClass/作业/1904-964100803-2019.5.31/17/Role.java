package homework;

 interface Role {
	int attack();
	void practices();
}

abstract class NamedRole implements Role{	//ʵ��Role
	 private String name;
	 private int age;
	 public NamedRole() {}
	 public NamedRole(String name, int age) {
			this.name = name;
			this.age = age;
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
}
interface  MagicStick{ //����
	 public int fire(); //������ֵ��int���ͼӳ�
}
interface Weapon{//����
	void setSoldier(Soldier s); //����ʹ����
	int fire(); //�˺�ֵ
}