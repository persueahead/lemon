package com.lemon.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * ��Ⱥʽ�����ӳ�
 * 
 */
public class ShardedJedisPoolDemo {

    public static void main(String[] args) {
        // �������ӳ�������Ϣ
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // �������������
        poolConfig.setMaxTotal(50);

        // ���弯Ⱥ��Ϣ
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("127.0.0.1", 6379));
        
        // ���弯Ⱥ���ӳ�
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(poolConfig, shards);
        ShardedJedis shardedJedis = null;
        try {
            // �����ӳ��л�ȡ��jedis��Ƭ����
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.set("test1", "value1");
            // ��redis�л�ȡ����
            String value = shardedJedis.get("test1");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                // �رգ���������Ƿ���Ч����Ч��Żص����ӳ��У���Ч������״̬
                shardedJedis.close();
            }
        }
       //13317507648
        // �ر����ӳ�
        shardedJedisPool.close();

    }
}
