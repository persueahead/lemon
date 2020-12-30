/**
 * 构造函数没有返回值类型，用于对象的初始化
 * 方法名为类名
 * 一个类可以定义多个构造方法(参数列表不一样)
  *即一个类有多重创建对象的方式
  *一般函数可以有返回值类型，声明了可以不调用，但是构造函数一旦声明，实例化
  *时必须调用其中一个，不声明会调用默认的无参构造函数
 */
public class GouZao {
   String name;
   int age;
   String sex;
   public void playGame() {
	   System.out.println(name+"打英雄联盟");
   }
   public void eat() {
	   System.out.println(name+"在吃饭");
   }
   public GouZao(String name1,int age1,String sex1) {
	   name=name1;
	   age=age1;
	   sex=sex1;
   }
   public static void main(String[] args) {
	GouZao t=new GouZao("张三",22,"男");
	System.out.println(t.name);
	t.playGame();			
}
}
