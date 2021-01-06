package com.jedis.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JeddisTest {

	/**
	 * ��ʵ������jedis
	 */
	@Test
	public void testJedis() {
		
		Jedis jedis = new Jedis("192.168.25.128",6379);
		
		jedis.set("name", "zhangsan");
		String name = jedis.get("name");
		System.out.println(name);
		System.out.println(jedis.get("age"));
		jedis.close();
		
	}
	
	
	/**
	 * ʹ�����ӳ�
	 */
	@Test
	public void pool() {
		
		JedisPoolConfig config = new JedisPoolConfig();
		//���������
		config.setMaxTotal(30);
		//������ӿ�����
		config.setMaxIdle(2);
		
		
		JedisPool pool = new JedisPool(config,"192.168.25.128",6379);
		Jedis jedis = null;
		
		try {
			
			jedis = pool.getResource();
			
			jedis.set("username", "zhubanjie");
			String name = jedis.get("username");
			System.out.println(name);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null) {
				//�ر�����
				jedis.close();
			}
		}
		
	}
	
}
