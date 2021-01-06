package com.jedis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class HashTest {

	public static void main(String[] args) {
		
		Jedis jedis = RedisUtil.getJedis();
		
		
		try {
			
			Map<String,String> map = new HashMap<>();
			map.put("userid", "1001");
			map.put("username", "zhangsan");
			map.put("usersex", "man");
			jedis.hmset("user:1:info", map);
			
			List<String> username = jedis.hmget("user:1:info", "username");
			System.out.println(username);
			 
			//删除map中某个键值
			jedis.hdel("user:1:info", "usersex");
			System.out.println(jedis.hmget("user:1:info", "usersex"));
			//返回字段的长度
			System.out.println(jedis.hlen("user:1:info"));
			//是否存在
			System.out.println(jedis.exists("user:2:info"));
			//返回map对象中所有的key
			System.out.println(jedis.hkeys("user:1:info"));
			//返回map对象中所有的value
			System.out.println(jedis.hvals("user:1:info"));
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			RedisUtil.closeJedis(jedis);
			
		}
		

	}

}
