package com.lemon.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolDemo {

    public static void main(String[] args) {
        // �������ӳ�������Ϣ
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // �������������
        jedisPoolConfig.setMaxTotal(50);

        // �������ӳ�
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);

        // �����ӳ��л�ȡ����
        Jedis jedis = jedisPool.getResource();

        // ��ȡ����
        System.out.println(jedis.get("a"));

        // �����ӻ��ص����ӳ���
        jedisPool.returnResource(jedis);

        // �ͷ����ӳ�
        jedisPool.close();

    }

}
