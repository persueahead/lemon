package com.jedis.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JeddisTest {

	/**
	 * 单实例连接jedis
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
	 * 使用连接池
	 */
	@Test
	public void pool() {
		
		JedisPoolConfig config = new JedisPoolConfig();
		//最大连接数
		config.setMaxTotal(30);
		//最大连接空闲数
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
				//关闭连接
				jedis.close();
			}
		}
		
	}
	
}
