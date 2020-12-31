package pojo;
//创建实体类，来接收用户提交的数据
public class Users {

	private  String  name;
	private  String  pwd;
	private  String  phone;
	private  Integer  age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", pwd=" + pwd + ", phone=" + phone + ", age=" + age + "]";
	}
	
	
	
	
}
