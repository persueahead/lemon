package com.jedis.test;

import java.util.Set;

import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class SortedSetTest {

	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();
		
		try {
			
			
			jedis.zadd("users", 1001,"����");
			jedis.zadd("users", 9527,"����");
			jedis.zadd("users", 2001,"�˽�");
			//��С�����ȡ
			Set<String> setvalues = jedis.zrange("users", 0, -1);
			System.out.println(setvalues);
			//�ɴ�С
			Set<String> setvalues2 = jedis.zrevrange("users", 0, -1);
			System.out.println(setvalues2);
			
			

			jedis.zadd("zset", 3.1,"aa");
			jedis.zadd("zset", 2.5,"bb");
			jedis.zadd("zset", 5.6,"cc");
			
			Set<String> setvalues3 = jedis.zrevrange("zset", 0, -1);
			System.out.println(setvalues3);
			
			//��ȡԪ�صĸ���
			System.out.println(jedis.zcard("zset"));
			
			//ɾ��Ԫ��
			System.out.println(jedis.zrem("zset", "aa"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
		
	}
	
}
