package com.jedis.test;

import java.util.Set;

import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class SetTest {

	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();

		try {
			
			//�������
			jedis.sadd("userset", "��ɮ");
			jedis.sadd("userset", "���");
			jedis.sadd("userset", "�˽�");
			jedis.sadd("userset", "��");
			
			//��ȡ��������
			Set<String> setValues = jedis.smembers("userset");
			
			System.out.println(setValues);
			
			//���ؼ��ϵ�Ԫ�ظ���
			System.out.println(jedis.scard("userset"));
			//�ж� ��˭����userset���ϵ�Ԫ��
			System.out.println(jedis.sismember("userset", "��"));
			//���ɾ��һ��Ԫ��  ��ջ
			//System.out.println(jedis.spop("userset"));
			
			//���²�ѯ
			//setValues = jedis.smembers("userset");
			//System.out.println(setValues);
			
			//ɾ��,ɾ���ɹ��������1
			System.out.println(jedis.srem("userset", "�˽�"));
			//���²�ѯ
			setValues = jedis.smembers("userset");
			System.out.println(setValues);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RedisUtil.closeJedis(jedis);
		}

	}
}
