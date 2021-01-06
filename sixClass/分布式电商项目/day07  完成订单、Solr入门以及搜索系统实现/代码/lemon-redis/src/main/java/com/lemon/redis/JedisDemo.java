package com.lemon.redis;

import redis.clients.jedis.Jedis;

public class JedisDemo {

    public static void main(String[] args) {
        // ����jedis����
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // ��redis���������
        jedis.set("mytest", "123");
        // ��redis�ж�ȡ����
        String value = jedis.get("mytest");

        System.out.println(value);
        // �ر�����
        jedis.close();

    }

}
