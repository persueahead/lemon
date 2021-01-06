package com.jedis.test;

import org.junit.Test;

import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class StringTest {

	@Test
	public void test1() {
		Jedis jedis = RedisUtil.getJedis();
		
		try {
			//key value 
			jedis.set("name", "zhangsan");
			String name = jedis.get("name");
			System.out.println(name);
			
			//append 追加
			jedis.append("name", " hello");
			System.out.println(jedis.get("name"));
			
			//覆盖
			jedis.set("name", "zhubajie");
			System.out.println(jedis.get("name"));
			
			//删除key对应的记录
			jedis.del("name");
			System.out.println(jedis.get("name")); // null
			
			//mset mget
			jedis.mset("name","wukong","age","18");
			System.out.println(jedis.mget("name"));
			System.out.println(jedis.mget("age"));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
		
	}
	
	
	@Test
	public void test2() {
		
		Jedis jedis = RedisUtil.getJedis();
		try {
		/*	//key value 
			jedis.set("name", "zhangsan");
			String name = jedis.get("name");
			System.out.println(name);
			
			//清空数据
			System.out.println(jedis.flushDB());
			
			//存储数据
			jedis.set("uname", "wukong");
			System.out.println(jedis.get("uname"));
			
			//setnx 如果key不存在,则存储
			jedis.setnx("uname", "18");
			System.out.println(jedis.get("uname"));*/
			
			//设置key的有效期,并存储数据
	/*		jedis.setex("username", 10, "zhangxiaosan");
			System.out.println(jedis.get("username"));
			
			try {
				Thread.sleep(15000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(jedis.get("username"));*/
			
			
			jedis.set("name", "zhangsan");
			//截取value的值
			System.out.println(jedis.getrange("name", 1, 3));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
		
		
		
	}
}
