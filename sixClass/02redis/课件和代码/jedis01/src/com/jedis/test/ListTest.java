package com.jedis.test;

import java.util.List;

import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class ListTest {

	public static void main(String[] args) {

		Jedis jedis = RedisUtil.getJedis();
		
		try {
			
			//ɾ��mylist������������
	/*		jedis.del("mylist");
			//���������
			jedis.lpush("mylist", "aa");
			jedis.lpush("mylist", "bb");
			jedis.lpush("mylist", "cc");
			jedis.lpush("mylist", "aa");
			jedis.lpush("mylist", "dd");
			jedis.lpush("mylist", "ee");*/
			
			
		
			
			
			//�������
			//jedis.flushDB();
			
	/*		jedis.rpush("mylist", "aa");
			jedis.rpush("mylist", "bb");
			jedis.rpush("mylist", "cc");
			jedis.rpush("mylist", "aa");
			jedis.rpush("mylist", "dd");
			jedis.rpush("mylist", "ee");
			
			//��ȡԪ��
			List<String> values = jedis.lrange("mylist", 0, -1);
			System.out.println(values);
			
			System.out.println(jedis.llen("mylist"));*/
			
			
			//�޸ı��е���ֵ
			//jedis.lset("mylist", 3, "Java");
			
			//System.out.println(jedis.lindex("mylist", 3));
			
			//ɾ���б�ָ���±��ֵ
			jedis.lrem("mylist", 1, "Java");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}

	}

}
