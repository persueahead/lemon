package com.jedis.test;

import java.util.List;

import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class HashTest2 {

	public static void main(String[] args) {
		
		Jedis jedis = RedisUtil.getJedis();
		
		List<String> list = jedis.lrange("de:de_id", 0, -1);
		for(String deId:list) {
			System.out.print(jedis.hget("de:"+deId, "de_id")+"  ");
			System.out.print(jedis.hget("de:"+deId, "de_name"));
			System.out.println();
		}

	}

}
