/**
 * ���캯��û�з���ֵ���ͣ����ڶ���ĳ�ʼ��
 * ������Ϊ����
 * һ������Զ��������췽��(�����б�һ��)
  *��һ�����ж��ش�������ķ�ʽ
  *һ�㺯�������з���ֵ���ͣ������˿��Բ����ã����ǹ��캯��һ��������ʵ����
  *ʱ�����������һ���������������Ĭ�ϵ��޲ι��캯��
 */
public class GouZao {
   String name;
   int age;
   String sex;
   public void playGame() {
	   System.out.println(name+"��Ӣ������");
   }
   public void eat() {
	   System.out.println(name+"�ڳԷ�");
   }
   public GouZao(String name1,int age1,String sex1) {
	   name=name1;
	   age=age1;
	   sex=sex1;
   }
   public static void main(String[] args) {
	GouZao t=new GouZao("����",22,"��");
	System.out.println(t.name);
	t.playGame();			
}
}
