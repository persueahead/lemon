package com.jedis.test;

import java.util.Set;

import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class SetTest {

	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();

		try {
			
			//添加内容
			jedis.sadd("userset", "唐僧");
			jedis.sadd("userset", "悟空");
			jedis.sadd("userset", "八戒");
			jedis.sadd("userset", "悟净");
			
			//获取所有内容
			Set<String> setValues = jedis.smembers("userset");
			
			System.out.println(setValues);
			
			//返回集合的元素个数
			System.out.println(jedis.scard("userset"));
			//判断 悟净谁都是userset集合的元素
			System.out.println(jedis.sismember("userset", "悟净"));
			//随机删除一个元素  出栈
			//System.out.println(jedis.spop("userset"));
			
			//重新查询
			//setValues = jedis.smembers("userset");
			//System.out.println(setValues);
			
			//删除,删除成功结果返回1
			System.out.println(jedis.srem("userset", "八戒"));
			//重新查询
			setValues = jedis.smembers("userset");
			System.out.println(setValues);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RedisUtil.closeJedis(jedis);
		}

	}
}
