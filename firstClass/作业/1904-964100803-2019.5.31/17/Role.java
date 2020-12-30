package homework;

 interface Role {
	int attack();
	void practices();
}

abstract class NamedRole implements Role{	//实现Role
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
interface  MagicStick{ //法杖
	 public int fire(); //其属性值，int类型加成
}
interface Weapon{//武器
	void setSoldier(Soldier s); //设置使用者
	int fire(); //伤害值
}