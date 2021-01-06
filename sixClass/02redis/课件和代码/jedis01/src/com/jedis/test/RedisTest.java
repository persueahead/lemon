package com.jedis.test;

import java.util.List;

import com.jedis.po.Dept;
import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		
		//��ѯ���еĲ�����Ϣ
		Jedis jedis = RedisUtil.getJedis();
		
		//��ѯ���ŵ�Id����
		List<String> list = jedis.lrange("dept:de_id", 0, -1);
		for(String deId:list) {
			String id = jedis.hget("dept:"+deId, "de_id");
			String name = jedis.hget("dept:"+deId, "de_name");
			Dept de = new Dept();
			de.setDeId(Integer.parseInt(id));
			de.setDeName(name);
			System.out.println(de);
		}
		jedis.close();
		
		
	}
}
