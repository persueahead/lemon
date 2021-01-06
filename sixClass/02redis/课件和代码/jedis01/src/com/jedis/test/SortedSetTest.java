package com.jedis.test;

import java.util.Set;

import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class SortedSetTest {

	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();
		
		try {
			
			
			jedis.zadd("users", 1001,"张三");
			jedis.zadd("users", 9527,"华安");
			jedis.zadd("users", 2001,"八戒");
			//由小到大获取
			Set<String> setvalues = jedis.zrange("users", 0, -1);
			System.out.println(setvalues);
			//由大到小
			Set<String> setvalues2 = jedis.zrevrange("users", 0, -1);
			System.out.println(setvalues2);
			
			

			jedis.zadd("zset", 3.1,"aa");
			jedis.zadd("zset", 2.5,"bb");
			jedis.zadd("zset", 5.6,"cc");
			
			Set<String> setvalues3 = jedis.zrevrange("zset", 0, -1);
			System.out.println(setvalues3);
			
			//获取元素的个数
			System.out.println(jedis.zcard("zset"));
			
			//删除元素
			System.out.println(jedis.zrem("zset", "aa"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			RedisUtil.closeJedis(jedis);
		}
		
	}
	
}
